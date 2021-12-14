package dev.olaore.newsfeed.util

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabColorSchemeParams

import dev.olaore.newsfeed.R

fun String.launchInBrowser(ctx: Context) {
    val customTabsIntentBuilder = CustomTabsIntent.Builder()

    val defaultColors = CustomTabColorSchemeParams.Builder()
        .setToolbarColor(ctx.resources.getColor(R.color.colorPrimary))
        .build()
    customTabsIntentBuilder.setDefaultColorSchemeParams(defaultColors)

    val customTabsIntent = customTabsIntentBuilder.build()

    customTabsIntent.launchUrl(ctx, Uri.parse(this))
}