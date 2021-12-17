package dev.olaore.newsfeed.util

import dev.olaore.newsfeed.data.models.newslist.remote.NewsItem
import dev.olaore.newsfeed.data.models.newslist.remote.NewsListContainer

object NewsListUtil {

     val NEWS_ITEMS = listOf(
        NewsItem(
            null,
            "Fouad Olaore",
            "This is a title",
            "This is the description",
            "https://url.com/news-url",
            "https://picsum.photos/100/100/100",
            "12am",
            "This is the content"
        ),
        NewsItem(
            null,
            "Fouad Olaore",
            "This is a title",
            "This is the description",
            "https://url.com/news-url",
            "https://picsum.photos/100/100/100",
            "12am",
            "This is the content"
        ),
        NewsItem(
            null,
            "Fouad Olaore",
            "This is a title",
            "This is the description",
            "https://url.com/news-url",
            "https://picsum.photos/100/100/100",
            "12am",
            "This is the content"
        ),
        NewsItem(
            null,
            "Fouad Olaore",
            "This is a title",
            "This is the description",
            "https://url.com/news-url",
            "https://picsum.photos/100/100/100",
            "12am",
            "This is the content"
        ),
        NewsItem(
            null,
            "Fouad Olaore",
            "This is a title",
            "This is the description",
            "https://url.com/news-url",
            "https://picsum.photos/100/100/100",
            "12am",
            "This is the content"
        ),
        NewsItem(
            null,
            "Fouad Olaore",
            "This is a title",
            "This is the description",
            "https://url.com/news-url",
            "https://picsum.photos/100/100/100",
            "12am",
            "This is the content"
        ),
        NewsItem(
            null,
            "Fouad Olaore",
            "This is a title",
            "This is the description",
            "https://url.com/news-url",
            "https://picsum.photos/100/100/100",
            "12am",
            "This is the content"
        ),
        NewsItem(
            null,
            "Fouad Olaore",
            "This is a title",
            "This is the description",
            "https://url.com/news-url",
            "https://picsum.photos/100/100/100",
            "12am",
            "This is the content"
        ),
        NewsItem(
            null,
            "Fouad Olaore",
            "This is a title",
            "This is the description",
            "https://url.com/news-url",
            "https://picsum.photos/100/100/100",
            "12am",
            "This is the content"
        ),
    )

    val NEWS_LIST_RESPONSE = NewsListContainer(
        "ok", NEWS_ITEMS.size, NEWS_ITEMS
    )

}