package dev.olaore.newsfeed.data.common.mappers

import dev.olaore.newsfeed.data.models.newslist.domain.DomainNewsItem
import dev.olaore.newsfeed.data.models.newslist.remote.NewsItem
import dev.olaore.newsfeed.data.models.newslist.remote.NewsListContainer

fun NewsListContainer.toDomainNewsList(): List<DomainNewsItem> {
    return this.articles.map { it.toDomainNewsItem() }
}

fun NewsItem.toDomainNewsItem(): DomainNewsItem {
    return DomainNewsItem(
        this.title!!,
        this.author ?: "No Author Provided",
        this.url!!,
        this.urlToImage!!
    )
}