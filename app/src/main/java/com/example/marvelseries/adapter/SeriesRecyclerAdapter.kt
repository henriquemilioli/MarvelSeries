package com.example.marvelseries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelseries.R
import com.example.marvelseries.model.Series

class SeriesRecyclerAdapter (
    private val series: List<Series>
):RecyclerView.Adapter<SeriesRecyclerAdapter.SeriesViewHolder>(){

    class SeriesViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){
        val textViewSeriesTitle: TextView = itemView.findViewById(R.id.textViewSeriesTitle)
        val textViewSeriesAno: TextView = itemView.findViewById(R.id.textViewSeriesAno)

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
    }

    override fun getItemCount(): Int = series.size

}