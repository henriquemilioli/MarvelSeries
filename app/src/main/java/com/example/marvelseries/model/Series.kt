package com.example.marvelseries.model


class Series (
    var id: Int? = null,
    var title: String? = null,
    var description: String? = null,
    var resourceURI: String? = null,
    var startYear: Int? = null,
    var endYear: Int? = null,
//    val thumbnail: SerieImage?,
){
    override fun toString(): String = "$title"
}

//class SerieImage (
//    val path: String?,
//    val extension: String?
//)