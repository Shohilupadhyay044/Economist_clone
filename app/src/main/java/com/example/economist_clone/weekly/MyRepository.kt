package com.example.economist_clone.weekly


class MyRepository {
    val apiClient=RetrofitGenerator.getInstance().create(WeeklyApiClient::class.java)
    val responseHandler = ResponseHandler()

    suspend fun getData(): Resource<List<ResponseModel>> {
        val result = apiClient.getData()
        return responseHandler.handleSuccess(result)
    }

}