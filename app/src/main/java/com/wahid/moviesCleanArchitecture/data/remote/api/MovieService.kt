package com.wahid.moviesCleanArchitecture.data.remote.api

import com.wahid.moviesCleanArchitecture.data.remote.dto.MovieDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface MovieService {

    @GET("discover/movie")
    suspend fun getAllMovies(
        @QueryMap filters: Map<String, String>,
        @Query(value = "page") page: Int
    ): Response<MovieDto>

}