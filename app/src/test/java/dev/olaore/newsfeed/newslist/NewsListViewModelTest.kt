package dev.olaore.newsfeed.newslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dev.olaore.newsfeed.coroutine_utils.MainCoroutineDispatcher
import dev.olaore.newsfeed.data.common.models.Result
import dev.olaore.newsfeed.data.remote.NewsService
import dev.olaore.newsfeed.data.remote.news.NewsApiHelper
import dev.olaore.newsfeed.ui.newslist.repositories.NewsListRepository
import dev.olaore.newsfeed.ui.newslist.viewmodels.NewsListViewModel
import dev.olaore.newsfeed.util.NewsListUtil
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.*
import java.lang.Exception

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NewsListViewModelTest {

    // mocked objects
    private lateinit var newsListRepository: NewsListRepository
    private lateinit var newsApiHelper: NewsApiHelper
    private lateinit var newsService: NewsService

    private lateinit var viewModel: NewsListViewModel

//    @get:Rule

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineDispatcher = MainCoroutineDispatcher()

    @Before
    fun setup() {

        newsService = mock()
        newsApiHelper = Mockito.mock(
            NewsApiHelper::class.java, withSettings().useConstructor(newsService)
        )
        newsListRepository = Mockito.mock(
            NewsListRepository::class.java, withSettings().useConstructor(newsApiHelper)
        )

    }

    @Test
    fun `test_getTopHeadlines_shouldReturn_listOfHeadlines`() = runBlockingTest {

        // arrange
        whenever (newsListRepository.getTopHeadlines()).thenReturn(NewsListUtil.NEWS_LIST_RESPONSE)

        val expectedNewsItems = NewsListUtil.NEWS_ITEMS

        // act
        viewModel = NewsListViewModel(newsListRepository)
        val actual = viewModel.topHeadlines.value

        // assert
        verify(newsService, times(1)).getTopHeadlines()
        assert(actual is Result.Success)
        Assert.assertEquals(
            expectedNewsItems.size, actual!!.data!!.size
        )

    }

    @Test
    fun `test_getTopHeadlines_shouldReturn_Error`() = runBlockingTest {

        // arrange
        val expectedMessage = "Error Occurred: Please check your request"
        whenever (newsListRepository.getTopHeadlines()).thenThrow(RuntimeException(expectedMessage))

        // act
        viewModel = NewsListViewModel(newsListRepository)
        val actual = viewModel.topHeadlines.value

        // assert
        verify(newsService, times(1)).getTopHeadlines()
        assert(actual is Result.Error)
        Assert.assertEquals(
            expectedMessage, actual!!.message
        )

    }

}