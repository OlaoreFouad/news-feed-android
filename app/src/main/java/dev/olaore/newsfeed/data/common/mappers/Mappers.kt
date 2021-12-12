package dev.olaore.newsfeed.data.common.mappers

import dev.olaore.newsfeed.data.models.newslist.NewsItem
import dev.olaore.newsfeed.data.models.newslist.NewsListContainer

fun NewsListContainer.toDomainNewsList(): List<NewsItem> {
    return this.articles
}