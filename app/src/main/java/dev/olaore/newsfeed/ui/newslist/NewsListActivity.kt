package dev.olaore.newsfeed.ui.newslist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import dev.olaore.newsfeed.data.common.models.Result
import dev.olaore.newsfeed.data.models.newslist.domain.DomainNewsItem
import dev.olaore.newsfeed.ui.common.components.Loader
import dev.olaore.newsfeed.ui.newslist.components.NewsItem
import dev.olaore.newsfeed.ui.newslist.theme.NewsFeedTheme
import dev.olaore.newsfeed.ui.newslist.viewmodels.NewsListViewModel

@AndroidEntryPoint
class NewsListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsFeedTheme {
                NewsListScreen()
            }
        }
    }
}

@Composable
fun NewsListScreen(
    viewmodel: NewsListViewModel = viewModel()
) {
    val newsListState by viewmodel.topHeadlines.observeAsState()
    Box(modifier = Modifier.padding(8.dp)) {
        when (newsListState) {
            is Result.Loading -> {
                Loader()
            }
            is Result.Error -> {
                val message: String = (newsListState as Result.Error<List<DomainNewsItem>>).message
                Toast.makeText(
                    LocalContext.current, "Error Occurred: $message", Toast.LENGTH_LONG
                ).show()
            }
            is Result.Success -> {
                val data: List<DomainNewsItem> =
                    (newsListState as Result.Success<List<DomainNewsItem>>).data!!
                NewsList(data)
            }
        }
    }
}

@Composable
fun NewsList(items: List<DomainNewsItem>) {
    LazyColumn {
        items(items) { item ->
            NewsItem(item)
        }
    }
}
