package ru.androidacademy.optimizations.computeonmain

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.f_compute_on_main_thread.*
import ru.androidacademy.optimizations.R

class ComputeOnMainThreadFragment : Fragment() {

    private val handler = Handler(Looper.getMainLooper())

    private val computeRunnable: Runnable by lazy {
        Runnable {
            seekBar?.apply {
                if (optimizationsSwitch?.isChecked == true) {
                    calcFibonachiSlowly(progress)
                    handler.post(computeRunnable)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_compute_on_main_thread, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Glide.with(this)
            .load(Uri.parse("file:///android_asset/android.gif"))
            .into(imageView)

        optimizationsSwitch.setOnCheckedChangeListener { _, checked ->
            seekBar.isEnabled = checked
            if (checked) {
                startComputations()
            } else {
                stopComputations()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        startComputations()
    }

    override fun onPause() {
        stopComputations()
        super.onPause()
    }

    private fun startComputations() {
        handler.post(computeRunnable)
    }

    private fun stopComputations() {
        handler.removeCallbacksAndMessages(null)
    }

    private fun calcFibonachiSlowly(num: Int): Int {
        return when {
            num <= 0 -> throw IllegalArgumentException()
            num == 1 -> 0
            num == 2 -> 1
            else -> calcFibonachiSlowly(num - 1) + calcFibonachiSlowly(num - 2)
        }
    }
}