package com.example.marvelseries.ui.series.list


import android.view.WindowInsets.Side.all
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelseries.Database.SeriesDao
import com.example.marvelseries.model.SerieSave
import com.example.marvelseries.model.Series
import com.google.common.collect.Iterables.all
import com.google.common.collect.Iterators.all
import com.google.common.collect.Range.all
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class ListMySeriesViewModel (private val seriesDao: SeriesDao) : ViewModel() {
    private val _series = MutableLiveData<List<Series>>()
    val series: LiveData<List<Series>> = _series

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg


    val user = FirebaseAuth.getInstance().currentUser
    var userid = user.uid
    init {
        viewModelScope.launch {
            seriesDao.all(userid).addOnSuccessListener {
                val series = it.toObjects(Series::class.java)
                _series.value = series
            }
        }
    }

}