package com.example.marvelseries.ui.series.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelseries.Database.SerieUtil
import com.example.marvelseries.R
import com.example.marvelseries.adapter.SeriesRecyclerAdapter
import com.example.marvelseries.model.Series
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class listSeriesFragment : Fragment() {

    lateinit var floatingActionButton: FloatingActionButton

    private lateinit var listSeriesViewModel: ListSeriesViewModel

    private lateinit var recyclerViewListSeries: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_series_fragment, container, false)


        recyclerViewListSeries = view.findViewById((R.id.recyclerViewListSeries)) // Widget

        floatingActionButton = view.findViewById(R.id.floatingActionButton)

        listSeriesViewModel = ViewModelProvider(this).get(ListSeriesViewModel::class.java)

        listSeriesViewModel.series.observe(viewLifecycleOwner, Observer {
            if(!it.isNullOrEmpty())
                recyclerViewListSeries.adapter = SeriesRecyclerAdapter(it){ // widget = adapter
                    SerieUtil.SerieSelecionada = it
                    findNavController().navigate(R.id.detalhesFragment)
                }
        })

        listSeriesViewModel.msg.observe(viewLifecycleOwner, Observer {
            if (it.isNullOrBlank())
                Snackbar
                    .make(
                        view,
                        it,
                        Snackbar.LENGTH_LONG
                    ).show()
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listSeriesViewModel.getSeries()
        floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.listMySeriesFragment)
        }
    }
}