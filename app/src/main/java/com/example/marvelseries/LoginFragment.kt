package com.example.marvelseries

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.facebook.*
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {


    private lateinit var callbackManager: CallbackManager
    private lateinit var viewModel: LoginViewModel
    private lateinit var loginButton: LoginButton
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val view = inflater.inflate(R.layout.login_fragment, container, false)

        // Initialize Facebook Login button
        callbackManager = CallbackManager.Factory.create()
        loginButton = view.findViewById((R.id.login_button))
        loginButton.setPermissions("email", "public_profile")
        loginButton.fragment = this


        auth = Firebase.auth

        loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                Log.d("Login Facebook", "facebook:onSuccess:$loginResult")
                handleFacebookAccessToken(loginResult.accessToken)
            }

            override fun onCancel() {
                Log.d("Login Facebook", "facebook:onCancel")
            }

            override fun onError(error: FacebookException) {
                Log.d("Login Facebook", "facebook:onError", error)
            }
        })
        return view

    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        Log.d("Facebook Token", "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Facebook Token", "signInWithCredential:success")
                    val user = auth.currentUser
                    findNavController().navigate(R.id.listSeriesFragment)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Facebook Token", "signInWithCredential:failure", task.exception)
                    Toast.makeText(requireContext(), "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Pass the activity result back to the Facebook SDK
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

}