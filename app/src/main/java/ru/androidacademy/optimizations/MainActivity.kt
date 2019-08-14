package ru.androidacademy.optimizations

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.checkSelfPermission
import jp.wasabeef.takt.Takt
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
        Takt.play()

    }

    override fun onStop() {
        super.onStop()
        if (checkSelfPermission(this, Manifest.permission.SYSTEM_ALERT_WINDOW) == PackageManager.PERMISSION_GRANTED) {
            Takt.finish()
        }
    }
}
