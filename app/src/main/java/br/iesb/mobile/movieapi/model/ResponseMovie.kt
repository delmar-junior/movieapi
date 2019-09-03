package br.iesb.mobile.movieapi.model

import com.google.gson.annotations.SerializedName

data class ResponseMovie (
    @SerializedName("id")
    var id: Number,
    @SerializedName("title")
    var title: String,
    @SerializedName("original_title")
    var originalTitle: String,
    @SerializedName("homepage")
    var homepage: String
)