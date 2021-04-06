package com.example.marvelseries.ui.series.list

import android.util.Log
import android.view.WindowInsets.Side.all
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelseries.api.service.ApiClient
import com.example.marvelseries.api.service.SeriesService
import com.example.marvelseries.model.Series
import kotlinx.coroutines.launch
import java.lang.Exception

class ListSeriesViewModel : ViewModel() {

    private val _series = MutableLiveData<List<Series>>()
    val series: LiveData<List<Series>> = _series

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg



    init {
        viewModelScope.launch {
            try {
                val seriesService = ApiClient.getSeriesService()
                _series.value = seriesService.all(20, 100)
            } catch (e: Exception){
                _msg.value = e.message
            }
        }
    }
}

//init {
//    viewModelScope.launch {
//        try {
//            val response =
//                ApiClient
//                    .getSeriesService().all(20, 100)
//            val data = response.data
//            if
//                    (data!= null)
//                _series.value = data!!.results
//        }catch (e: Exception){
//            Log.i("LCVWResponde",
//                "${e.message}")

//        }

//    }
//}
//}