package com.example.marvelseries.Database

import com.example.marvelseries.model.SerieSave
import com.google.android.gms.tasks.Task


interface SeriesDao {
    fun create(serie: SerieSave): Task<Void>

    fun delete(serie: SerieSave): Task<Void>


}