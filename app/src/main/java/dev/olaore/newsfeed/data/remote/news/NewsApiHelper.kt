package dev.olaore.newsfeed.data.remote.news

import dev.olaore.newsfeed.data.models.newslist.remote.NewsListContainer
import dev.olaore.newsfeed.data.remote.NewsService
import javax.inject.Inject

open class NewsApiHelper @Inject constructor (
    private val newsService: NewsService
) {

    suspend fun getTopHeadlines(): NewsListContainer = newsService.getTopHeadlines()

}