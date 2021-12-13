package dev.olaore.newsfeed.data.models.newslist.remote


data class NewsListContainer(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsItem>
)