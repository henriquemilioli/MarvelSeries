package com.example.marvelseries.ui.series.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.marvelseries.Database.SerieDaoimpl
import com.example.marvelseries.Database.SerieUtil
import com.example.marvelseries.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class DetalhesFragment : Fragment() {
    private lateinit var viewModel: DetalhesViewModel

    private lateinit var detalheTituloSerie: TextView

    private lateinit var buttonRemoverDaLista: Button
    private lateinit var buttonSalvar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detalhes_fragment, container, false)

        detalheTituloSerie = view.findViewById(R.id.detalheTituloSerie)
        buttonRemoverDaLista = view.findViewById(R.id.buttonRemoverDaLista)
        buttonSalvar = view.findViewById(R.id.buttonSalvar)


        val detalhesViewModelFactory = DetalhesViewModelFactory(SerieDaoimpl())
        viewModel = ViewModelProvider(this, detalhesViewModelFactory).get(DetalhesViewModel::class.java)

        viewModel.series.observe(viewLifecycleOwner, Observer {
            detalheTituloSerie.text = it.title?.toString()
            //.setText(it.startYear)

        })
        viewModel.msg.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrBlank())
                Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
        })

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (SerieUtil.SerieSelecionada == null)
            buttonRemoverDaLista.visibility = View.GONE;




        val user = FirebaseAuth.getInstance().currentUser
        if (SerieUtil.SerieSelecionada != null){
            viewModel.listarserieEspecifica(SerieUtil.SerieSelecionada!!.id!!)
        }

        buttonSalvar.setOnClickListener {
            if (SerieUtil.SerieSelecionada != null) {
                viewModel.salvarSerie(SerieUtil.SerieSelecionada!!)
                findNavController().navigate(R.id.listMySeriesFragment)
            }else {
                Snackbar.make(view, "Serie não pode ser salva! Selecione uma serie.", Snackbar.LENGTH_LONG).show()
            }
        }
        buttonRemoverDaLista.setOnClickListener {
            if (SerieUtil.SerieSelecionada != null) {
                viewModel.removerDaLista(SerieUtil.SerieSelecionada!!)
                findNavController().popBackStack()
            }else {
                Snackbar.make(view, "Serie deletada.", Snackbar.LENGTH_LONG).show()
            }
        }
    }

}