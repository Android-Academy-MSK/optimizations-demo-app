package ru.androidacademy.optimizations.toobigimages

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.androidacademy.optimizations.R

class TooBigImagesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_too_big_images)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, TooBigImagesActivity::class.java))
        }
    }
}