package dev.olaore.newsfeed.data.remote

import dev.olaore.newsfeed.data.models.newslist.NewsListContainer
import dev.olaore.newsfeed.util.Constants
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.http.GET

interface NewsService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(): NewsListContainer

}

class NewsApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("country", Constants.NEWS_DEFAULT_COUNTRY)
            .addQueryParameter("apiKey", Constants.NEWS_API_KEY)
            .build()

        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)

    }

}