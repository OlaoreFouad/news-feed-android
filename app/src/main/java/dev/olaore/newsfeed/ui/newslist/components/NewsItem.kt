package dev.olaore.newsfeed.ui.newslist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.glide.GlideImage
import dev.olaore.newsfeed.R
import dev.olaore.newsfeed.data.models.newslist.domain.DomainNewsItem
import dev.olaore.newsfeed.ui.newslist.theme.ralewayFontFamily
import dev.olaore.newsfeed.util.launchInBrowser


@Composable
fun NewsItem(item: DomainNewsItem) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
    ) {
        GlideImage(
            imageModel = item.imageUrl,
            contentDescription = item.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.colorTransluscentBlack))
                .fillMaxHeight()
                .padding(8.dp)
                .clickable {
                    if (item.url.isNotEmpty()) {
                        item.url.launchInBrowser(context)
                    }
                },
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = item.title,
                color = colorResource(id = R.color.white),
                fontSize = 18.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontStyle = FontStyle.Normal,
                fontFamily = ralewayFontFamily
            )
            Text(
                text = item.author,
                color = colorResource(id = R.color.white),
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                fontFamily = ralewayFontFamily
            )
        }
    }
    Spacer(modifier = Modifier.height(4.dp))
}

@Preview
@Composable
fun PreviewNewsItem() {
    NewsItem(
        item = DomainNewsItem(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed venenatis est ut justo auctor tempor. Cras ut tincidunt nibh. Pellentesque volutpat risus vulputate vulputate mollis",
            "Fouad Olaore",
            "https://picsum.photos/100/100/100",
            imageUrl = "https://picsum.photos/id/237/200/300"
        )
    )
}