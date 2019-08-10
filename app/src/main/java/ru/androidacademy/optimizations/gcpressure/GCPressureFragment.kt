package ru.androidacademy.optimizations.gcpressure

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.f_gc_pressure.*
import ru.androidacademy.optimizations.R
import java.util.*


class GCPressureFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.f_gc_pressure, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        startPressure.setOnClickListener { _ ->
            imPrettySureSortingIsFree()
        }
        Glide.with(this)
            .load(Uri.parse("file:///android_asset/android.gif"))
            .into(imageView)
    }

    /**
     * Sorts and prints every row of a 2D array, one element at a time.
     * Original sample is here
     * https://github.com/udacity/ud825-compute-and-memory/blob/2.51_memory_churn/Compute/app/src/main/java/com/example/android/mobileperf/compute/MemoryChurnActivity.java
     */
    private fun imPrettySureSortingIsFree() {
        // Throw together a nice, big 2D array of random numbers.
        val dimension = 300
        val lotsOfInts = Array(dimension) { IntArray(dimension) }
        val randomGenerator = Random()
        for (i in lotsOfInts.indices) {
            for (j in 0 until lotsOfInts[i].size) {
                lotsOfInts[i][j] = randomGenerator.nextInt()
            }
        }

        // Now go through and dump the sorted version of each row to output!
        for (i in lotsOfInts.indices) {
            var rowAsStr = ""
            for (j in 0 until lotsOfInts[i].size) {
                // Clearly, the only reasonable way to construct a string is one character at a
                // time, with lots and lots of convenient concatenation.
                rowAsStr += getSorted(lotsOfInts[i])[j]
                if (j < lotsOfInts[i].size - 1) {
                    rowAsStr += ", "
                }
            }
            Log.i("CachingActivityExercise", "Row $i: $rowAsStr")
        }
    }

    /**
     * Helper method, returns the sorted copy of an array.
     * @param input the unsorted array
     * @return the sorted array
     */
    private fun getSorted(input: IntArray): IntArray {
        val clone = input.clone()
        Arrays.sort(clone)
        return clone
    }
}