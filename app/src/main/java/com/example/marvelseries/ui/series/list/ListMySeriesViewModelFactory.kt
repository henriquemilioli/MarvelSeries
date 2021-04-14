package com.example.marvelseries.ui.series.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marvelseries.Database.SeriesDao

class ListMySeriesViewModelFactory (val seriesDao: SeriesDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListMySeriesViewModel::class.java))
            return ListMySeriesViewModel(seriesDao) as T
        throw IllegalArgumentException("wrong viewmodel")
    }
}