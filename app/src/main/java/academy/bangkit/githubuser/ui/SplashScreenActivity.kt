package academy.bangkit.githubuser.ui

import academy.bangkit.githubuser.R
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val splashScreenIntent = Intent(this, ListUserActivity::class.java)
            startActivity(splashScreenIntent)
            finish()
        }, SPLASHSCREEN_TIME)
    }

    companion object {
        private const val SPLASHSCREEN_TIME = 2000L
    }
}