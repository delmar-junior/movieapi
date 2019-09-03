package br.iesb.mobile.movieapi.model

import com.google.gson.annotations.SerializedName

data class ResponseWapper(
    @SerializedName("page")
    var page: Number,
    @SerializedName("total_results")
    var totalResults: Number,
    @SerializedName("total_pages")
    var totalPages: Number,
    @SerializedName("results")
    var results: List<Movie>
)

data class Movie(
    @SerializedName("id")
    var id: Number,
    @SerializedName("title")
    var title: String
)