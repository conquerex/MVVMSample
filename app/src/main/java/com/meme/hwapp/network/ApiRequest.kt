package com.meme.hwapp.network

import com.meme.hwapp.response.ImagesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {

    @GET("services/rest/")
    fun getImages(
        @Query("method") query: String = "flickr.photos.search",
        @Query("api_key") apiKey: String = "281583d4a69a4fd53e101a375b3d1636",
        @Query("text") text: String = "'beauty'",
        @Query("per_page") perPage: String = "10",
        @Query("page") page: String = "1",
        @Query("format") format: String = "json",
        @Query("nojsoncallback") nojsoncallback: String = "1"
    ): Call<ImagesResponse>
}