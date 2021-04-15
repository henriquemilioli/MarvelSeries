package com.example.marvelseries.ui.series.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelseries.Database.SeriesDao
import com.example.marvelseries.api.service.ApiClient
import com.example.marvelseries.model.SerieSave
import com.example.marvelseries.model.Series
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import java.lang.Exception

class DetalhesViewModel (private val seriesDao: SeriesDao) : ViewModel() {
    private val _series = MutableLiveData<Series>()
    val series: LiveData<Series> = _series
    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg
    fun listarserieEspecifica(title: Int) {
        viewModelScope.launch {
            try {
                val response = ApiClient.getSeriesService().readOnly(title)
                _series.value = response.data!!.results!![0]
            }catch(e: Exception){
                _msg.value = e.message
            }

        }
    }
    fun salvarSerie(serie: Series){
//        var series = SerieSave(id,ano)
        val user = FirebaseAuth.getInstance().currentUser
        var userid = user.uid
        seriesDao.create(serie, userid)

    }

    fun removerDaLista(serie: Series)
    {
        val user = FirebaseAuth.getInstance().currentUser
        var userid = user.uid
            seriesDao.delete(serie, userid)
    }
}