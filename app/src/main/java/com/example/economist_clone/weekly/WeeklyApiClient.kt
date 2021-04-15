package com.example.economist_clone.weekly

import retrofit2.http.GET

interface WeeklyApiClient {
    @GET("news")
   suspend fun getData():List<ResponseModel>


}