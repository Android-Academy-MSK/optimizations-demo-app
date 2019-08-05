package ru.androidacademy.optimizations.toobigimages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.f_too_big_images.*
import ru.androidacademy.optimizations.R

class TooBigImagesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_too_big_images, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = requireContext()
        val bigImagesAdapter = BigImagesAdapter(context, optimizationsSwitch.isChecked)
        rvImagesList.adapter = bigImagesAdapter
        optimizationsSwitch.setOnCheckedChangeListener { _, value ->
            bigImagesAdapter.updateOptionsChoosing(value)
        }
        rvImagesList.layoutManager = GridLayoutManager(context, 3)
    }
}