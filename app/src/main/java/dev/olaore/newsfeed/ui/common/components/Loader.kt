package dev.olaore.newsfeed.ui.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import dev.olaore.newsfeed.R

@Preview(showBackground = true)
@Composable
fun Loader() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
            color = colorResource(R.color.colorPrimary)
        )
    }
}
