package com.giaidac.ccjackpot.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpActivity
import com.giaidac.ccjackpot.R
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class SplashScreen : JumpActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            splashAction { _, _ ->
                startActivity(MainActivity.createIntent(this@SplashScreen))
                finish()
            }
        }, 1500)
    }
}