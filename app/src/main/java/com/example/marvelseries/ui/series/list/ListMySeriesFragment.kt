package com.example.marvelseries.ui.series

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marvelseries.ui.series.list.ListMySeriesViewModel
import com.example.marvelseries.R

class listMySeriesFragment : Fragment() {

    companion object {
        fun newInstance() = listMySeriesFragment()
    }

    private lateinit var viewModel: ListMySeriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_my_series_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListMySeriesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}