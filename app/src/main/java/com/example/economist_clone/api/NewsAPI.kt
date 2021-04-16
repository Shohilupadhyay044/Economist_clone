package com.example.economist_clone.api

import com.example.economist_clone.models.NewsResponse
import com.example.economist_clone.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("api/breakingnews")
    suspend fun getBreakingNews(
//        @Query("country")
//        countryCode: String = "us",
//        @Query("domains")
//        pageNumber : String ="wsj.com",
//        @Query("apiKey")
//        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("api/searchnews")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String
//        @Query("sources")
//        pageNumber: String = "techcrunch",
//        @Query("apiKey")
//        apiKey: String = API_KEY
    ): Response<NewsResponse>
}