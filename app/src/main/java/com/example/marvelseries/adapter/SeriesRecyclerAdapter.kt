package com.example.marvelseries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelseries.R
import com.example.marvelseries.model.Series
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso

class SeriesRecyclerAdapter (
    private val series: List<Series>,
    val actionClick: (Series) -> Unit
):RecyclerView.Adapter<SeriesRecyclerAdapter.SeriesViewHolder>(){

    val storageReference = FirebaseStorage.getInstance().reference

    class SeriesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textViewSeriesTitle: TextView = itemView.findViewById(R.id.textViewSeriesTitle)
        val textViewSeriesAno: TextView = itemView.findViewById(R.id.textViewSeriesAno)
        //val imageSeriesView: ImageView = itemView.findViewById(R.id.imageSeriesView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
       val view = LayoutInflater
           .from(parent.context)
           .inflate(
               R.layout.recycler_series_layout,
               parent, false
           )
        return SeriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val series = series[position]
        holder.textViewSeriesTitle.text = series.title
        holder.textViewSeriesAno.text = series.startYear.toString()

        holder.itemView.setOnClickListener{
            actionClick(series)
        }

    }

    override fun getItemCount(): Int = series.size

}