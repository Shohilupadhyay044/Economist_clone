package com.example.economist_clone.repository

import com.example.economist_clone.api.RetrofitInstance
import com.example.economist_clone.database.ArticleDatabase
import com.example.economist_clone.models.Article


class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews() =
        RetrofitInstance.api.getBreakingNews()

    suspend fun searchNews(searchQuery: String) =
        RetrofitInstance.api.searchForNews(searchQuery)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}