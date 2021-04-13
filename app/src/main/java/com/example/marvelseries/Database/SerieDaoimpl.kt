package com.example.marvelseries.Database

import com.example.marvelseries.model.SerieSave
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class SerieDaoimpl {
    val firebaseInstance  = FirebaseFirestore.getInstance().collection("Series")

    fun create(serie: SerieSave): Task<Void> {
        return firebaseInstance.document(serie.id!!.toString()).collection("SeriesUser").document().set(serie)
    }

    fun delete(serie: SerieSave): Task<Void> {
        return firebaseInstance.document(serie.id!!.toString()).collection("SeriesUser").document().delete()
    }

    fun all(userid:String): Task<QuerySnapshot> {
        return firebaseInstance.document(userid).collection("SeriesUser").get()
    }
}


