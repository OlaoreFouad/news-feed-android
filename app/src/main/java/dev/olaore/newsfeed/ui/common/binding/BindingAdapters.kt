package dev.olaore.newsfeed.ui.common.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImageUrl")
fun loadImageUrl(imageView: ImageView, url: String) {
    Glide.with(imageView).load(url).into(imageView)
}