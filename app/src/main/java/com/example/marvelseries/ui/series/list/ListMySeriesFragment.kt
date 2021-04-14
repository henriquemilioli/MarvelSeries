package com.example.marvelseries.ui.series

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelseries.Database.SerieDaoimpl
import com.example.marvelseries.Database.SerieUtil
import com.example.marvelseries.ui.series.list.ListMySeriesViewModel
import com.example.marvelseries.R
import com.example.marvelseries.adapter.RecyclerMySeries
import com.example.marvelseries.model.Series
import com.example.marvelseries.ui.series.list.ListMySeriesViewModelFactory
import com.google.android.gms.common.config.GservicesValue.value
import com.google.android.material.snackbar.Snackbar

class listMySeriesFragment : Fragment() {

        private lateinit var viewModel: ListMySeriesViewModel

        private lateinit var recyclerListMySeries: RecyclerView

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val view = inflater.inflate(R.layout.list_my_series_fragment, container, false)

            recyclerListMySeries = view.findViewById((R.id.RecyclerListMySeries))


            val listMySeriesViewModelFactoryView = ListMySeriesViewModelFactory(SerieDaoimpl())
            viewModel = ViewModelProvider(this, listMySeriesViewModelFactoryView).get(ListMySeriesViewModel::class.java)
            SerieUtil.title = null
            viewModel.series.observe(viewLifecycleOwner, Observer {
                if (!it.isNullOrEmpty())
                    // minhaRecyclerViewWidgetId.adapter = SeuRecyclerAdapter()
                    recyclerListMySeries.adapter = RecyclerMySeries(it){
                        SerieUtil.title = it
                        findNavController().navigate(R.id.RecyclerListMySeries)
                    }
                //LinearLayoutManager(requireContext()).also { RecyclerMySeries.layoutManager = it }
                recyclerListMySeries.layoutManager = LinearLayoutManager(requireContext())

            })
            viewModel.msg.observe(viewLifecycleOwner, Observer {
                if (!it.isNullOrBlank())
                    Snackbar.make(view,it, Snackbar.LENGTH_LONG).show()
            })

            return  view
        }

}