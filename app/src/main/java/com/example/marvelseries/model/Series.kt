package com.example.marvelseries.model

import android.media.Image

class Series (
    val id: Int?,
    val title: String?,
    val description: String?,
    val resourceURI: String?,
    val startYear: Int?,
    val endYear: Int?,
//    val thumbnail: SerieImage?,
){
    override fun toString(): String = "$title"
}

//class SerieImage (
//    val path: String?,
//    val extension: String?
//)