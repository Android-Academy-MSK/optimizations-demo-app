package ru.androidacademy.optimizations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.a_main.*
import ru.androidacademy.optimizations.computeonmain.ComputeOnMainThreadActivity
import ru.androidacademy.optimizations.gcpressure.GCPressureActivity
import ru.androidacademy.optimizations.toobigimages.TooBigImagesActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)

        btnTooBigImages.setOnClickListener {
            TooBigImagesActivity.start(this)
        }

        btnComputeOnMain.setOnClickListener {
            ComputeOnMainThreadActivity.start(this)
        }

        btnGCPressure.setOnClickListener {
            GCPressureActivity.start(this)
        }
    }
}
