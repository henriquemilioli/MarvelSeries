package com.example.marvelseries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //FirebaseFirestore
        //val firebaseFirestore = FirebaseFirestore.getInstance()

        //collection
        //val collection = firebaseFirestore.collection("Series")

        //Ler um dado

        //Escrever um dado
        //Criar um documento
        //collection.add()

    }
}


//Firebase Storage
//val firebaseStorage = FirebaseStorage.getInstance()
//Referencia para a raiz do storage
//val storageReference = firebaseStorage.reference

//Apontar para o arquivo [Series]
//val fileReference = StorageReference

//Download
//fileReference.getBytes()
//Upload