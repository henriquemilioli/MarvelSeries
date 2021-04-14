package com.example.marvelseries.ui.series.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marvelseries.Database.SeriesDao
import java.lang.IllegalArgumentException

class DetalhesViewModelFactory(val seriesDao: SeriesDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetalhesViewModel::class.java)){
            return DetalhesViewModel(seriesDao) as T
        }
        throw IllegalArgumentException("Exception")
    }

}