package ru.androidacademy.optimizations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.a_main.*
import ru.androidacademy.optimizations.toobigimages.TooBigImagesActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)

        btnTooBigImages.setOnClickListener {
            TooBigImagesActivity.start(this)
        }
    }
}
