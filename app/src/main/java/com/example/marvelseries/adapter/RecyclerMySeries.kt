package com.example.marvelseries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelseries.R
import com.example.marvelseries.model.SerieSave
import com.example.marvelseries.model.Series
import com.google.firebase.storage.FirebaseStorage

    class RecyclerMySeries (
        private val series: List<Series>,
        val actionClick: (Series) -> Unit
):RecyclerView.Adapter<RecyclerMySeries.MySeriesViewHolder>(){

        val storageReference = FirebaseStorage.getInstance().reference

        class MySeriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textViewMySeriesTitle: TextView = itemView.findViewById(R.id.textViewMySeriesTitle)
            val textViewMySeriesAno: TextView = itemView.findViewById(R.id.textViewMySeriesAno)


        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerMySeries.MySeriesViewHolder {
            val view = LayoutInflater
                    .from(parent.context)
                    .inflate(
                            R.layout.recycler_myseries_list,
                            parent,
                            false
                    )
            return RecyclerMySeries.MySeriesViewHolder(view)
        }

        override fun onBindViewHolder(holder: MySeriesViewHolder, position: Int) {
            val series = series[position]
            holder.textViewMySeriesTitle.text = series.title
            holder.textViewMySeriesAno.text = series.startYear.toString()

            holder.itemView.setOnClickListener{
                actionClick(series)
            }
        }

        override fun getItemCount(): Int = series.size
}