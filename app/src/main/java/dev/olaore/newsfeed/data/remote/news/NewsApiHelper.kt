package dev.olaore.newsfeed.data.remote.news

import dev.olaore.newsfeed.data.models.newslist.NewsListContainer
import dev.olaore.newsfeed.data.remote.NewsService
import javax.inject.Inject

class NewsApiHelper @Inject constructor (
    private val newsService: NewsService
) {

    suspend fun getTopHeadlines(): NewsListContainer = newsService.getTopHeadlines()

}