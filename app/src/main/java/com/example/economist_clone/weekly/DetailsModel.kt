package com.example.economist_clone.weekly


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DetailsModel(

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("urlToImage")
	val urlToImage: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("description")
    val description: String? = null
)