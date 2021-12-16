package dev.olaore.newsfeed.ui.newslist.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.olaore.newsfeed.data.common.mappers.toDomainNewsList
import dev.olaore.newsfeed.ui.newslist.repositories.NewsListRepository
import dev.olaore.newsfeed.data.common.models.Result
import dev.olaore.newsfeed.data.models.newslist.domain.DomainNewsItem
import dev.olaore.newsfeed.data.models.newslist.remote.NewsItem
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val newsListRepository: NewsListRepository
) : ViewModel() {

    private var _topHeadlines = MutableLiveData<Result<List<DomainNewsItem>>>()
    val topHeadlines: LiveData<Result<List<DomainNewsItem>>>
        get() = _topHeadlines

    init {
        getTopHeadlines()
    }

    private fun getTopHeadlines() {
        _topHeadlines.postValue(Result.Loading())
        viewModelScope.launch {
            try {
                val newsListContainer = newsListRepository.getTopHeadlines()
                _topHeadlines.postValue(Result.Success(newsListContainer.toDomainNewsList()))
            } catch(ex: Exception) {
                _topHeadlines.postValue(Result.Error(ex.message ?: ""))
            }
        }
    }

}