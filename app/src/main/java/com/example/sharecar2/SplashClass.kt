package com.example.sharecar2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class SplashClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        // making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        //splash time
        Handler().postDelayed({
            // start login activity
            startActivity(Intent(this@SplashClass, LoginActivity::class.java))
            //finish the activity
            finish()
        }, 1500)


    }
}