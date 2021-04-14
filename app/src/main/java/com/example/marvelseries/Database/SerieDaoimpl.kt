package com.example.marvelseries.Database

import com.example.marvelseries.model.SerieSave
import com.example.marvelseries.model.Series
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class SerieDaoimpl: SeriesDao {
    val firebaseInstance  = FirebaseFirestore.getInstance().collection("Series")

    override fun create(serie: Series): Task<Void> {
        return firebaseInstance.document(serie.title!!.toString()).collection("SeriesUser").document().set(serie)
    }

    override fun delete(serie: Series): Task<Void> {
        return firebaseInstance.document(serie.title!!.toString()).collection("SeriesUser").document().delete()
    }

    override fun all(userid:String): Task<QuerySnapshot> {
        return firebaseInstance.document(userid).collection("SeriesUser").get()
    }
}


