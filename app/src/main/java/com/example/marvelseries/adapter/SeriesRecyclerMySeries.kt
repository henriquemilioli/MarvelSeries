package com.example.marvelseries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelseries.R
import com.example.marvelseries.model.SerieSave
import com.google.firebase.storage.FirebaseStorage

    class SeriesRecyclerMySeries (
        private val series: List<SerieSave>,
        val actionClick: (SerieSave) -> Unit
    ) :RecyclerView.Adapter<SeriesRecyclerMySeries.MySeriesViewHolder>(){
        val storageReference = FirebaseStorage.getInstance().reference

        class MySeriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
            val textViewSeriesTitle: TextView = itemView.textViewSeriesTitle
            val textViewSeriesAno: TextView = itemView.textViewSeriesAno


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesRecyclerMySeries.MySeriesViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.recycler_myseries_list,
                parent,
                false
            )
        return SeriesRecyclerMySeries.MySeriesViewHolder(view)
}
