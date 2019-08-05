package ru.androidacademy.optimizations.toobigimages

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import ru.androidacademy.optimizations.R
import java.util.*

private const val TAG = "BigImagesAdapter"

class BigImagesAdapter(
    context: Context,
    shouldChooseGoodOptionsDefault: Boolean
) : RecyclerView.Adapter<BigImagesAdapter.Holder>() {

    private var shouldChooseGoodOptions: Boolean = shouldChooseGoodOptionsDefault

    private val glide = Glide.with(context)

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    fun updateOptionsChoosing(shouldChooseGoodOptions: Boolean) {
        this.shouldChooseGoodOptions = shouldChooseGoodOptions
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(inflater.inflate(R.layout.i_image_holder, parent, false))
    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(glide, shouldChooseGoodOptions)
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(glide: RequestManager, shouldChooseGoodOptions: Boolean) {
            glide.load(drawables[random.nextInt(drawables.size)])
                .apply(
                    if (shouldChooseGoodOptions) {
                        goodOptions
                    } else {
                        wrongOptions
                    }
                )
                .listener(ResourceSizeLogger())
                .into(itemView as ImageView)
        }

        companion object {

            private val random = Random()

            private val drawables = arrayOf(
                R.drawable.bald_eagle,
                R.drawable.french_desert,
                R.drawable.looking_out_over_the_setting_sun,
                R.drawable.mansion_in_the_canyon,
                R.drawable.road_to_nowhere,
                R.drawable.skyscraper,
                R.drawable.snare_drum_second_take,
                R.drawable.swiss_mountains,
                R.drawable.yellowstone_river
            )

            private val wrongOptions = RequestOptions()
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)


            private val goodOptions = RequestOptions().fitCenter()
        }
    }
}

private class ResourceSizeLogger : RequestListener<Drawable?> {
    override fun onLoadFailed(
        e: GlideException?,
        model: Any?,
        target: Target<Drawable?>?,
        isFirstResource: Boolean
    ): Boolean {
        Log.e(TAG, "Error loading", e)
        return false
    }

    override fun onResourceReady(
        resource: Drawable?,
        model: Any?,
        target: Target<Drawable?>?,
        dataSource: DataSource?,
        isFirstResource: Boolean
    ): Boolean {
        resource?.apply {
            Log.d(TAG, "Loaded drawable size is ${resource.intrinsicWidth}x${resource.intrinsicHeight}")
        }

        return false
    }
}
