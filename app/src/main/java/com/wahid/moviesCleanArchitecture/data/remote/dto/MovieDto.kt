package com.wahid.moviesCleanArchitecture.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("results")
    val results: List<MovieRemoteModel>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int,
    @SerializedName("page")
    val page: Int,
)