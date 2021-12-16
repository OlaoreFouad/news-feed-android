package dev.olaore.newsfeed.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import dev.olaore.newsfeed.R
import dev.olaore.newsfeed.ui.newslist.NewsListActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler().postDelayed({
            this.openMainApplication()
        }, 2000)

    }

    private fun openMainApplication() {
        startActivity(Intent(
            this, NewsListActivity::class.java
        ))
    }

}