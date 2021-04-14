package com.example.marvelseries.Database

import com.example.marvelseries.model.SerieSave
import com.example.marvelseries.model.Series
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot


interface SeriesDao {
    fun create(serie: Series): Task<Void>

    fun delete(serie: Series): Task<Void>

    fun  all(userid:String): Task<QuerySnapshot>


}