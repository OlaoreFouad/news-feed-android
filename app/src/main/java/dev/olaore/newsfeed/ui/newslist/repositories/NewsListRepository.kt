package dev.olaore.newsfeed.ui.newslist.repositories

import dev.olaore.newsfeed.data.models.newslist.remote.NewsListContainer
import dev.olaore.newsfeed.data.remote.news.NewsApiHelper
import javax.inject.Inject

class NewsListRepository @Inject constructor(
    private val newsApiHelper: NewsApiHelper
) {

    suspend fun getTopHeadlines(): NewsListContainer = newsApiHelper.getTopHeadlines()

}