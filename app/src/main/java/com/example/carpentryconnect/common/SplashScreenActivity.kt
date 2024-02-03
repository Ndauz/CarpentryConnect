package com.example.carpentryconnect.common

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.carpentryconnect.R
import com.example.carpentryconnect.auth.SignInActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()
        val windowInsetsController = WindowCompat
            .getInsetsController(window, window.decorView)
        windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat
            .BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())

        animateLogo()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }, 3000)
    }

    private fun animateLogo() {
        val imageView = findViewById<ImageView>(R.id.logo)
        ObjectAnimator.ofFloat(imageView,
            "scaleX",
                    0.5f, 1f)
            .apply {
                duration = 1000
                interpolator = AccelerateInterpolator()
            }.start()
        ObjectAnimator.ofFloat(imageView,
            "scaleY",
            0.6f, 1f)
            .apply {
                duration = 1000
                interpolator = AccelerateInterpolator()
            }.start()
    }
}