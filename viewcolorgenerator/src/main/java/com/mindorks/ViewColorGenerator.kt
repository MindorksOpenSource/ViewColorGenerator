package com.mindorks

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import com.mindorks.util.Util
import android.support.v7.graphics.Palette
import android.util.Log
import com.mindorks.`interface`.*
import com.mindorks.util.Util.colorToHex
import com.squareup.picasso.Picasso


/**
 * @author Himanshu Singh
 * This library is used to generated Color and Swatches of a given Resource Image
 */
class ViewColorGenerator {
    /**
     * Declare variables
     */
    private var vibrant = 0
    private var vibrantLight = 0
    private var vibrantDark = 0
    private var muted = 0
    private var mutedLight = 0
    private var mutedDark = 0
    private var dominantColor = 0
    private val defaultValue = 0x000000

    init {

    }

    /**
     * @param srcType is the type of ViewPassed
     * @param interfaceType is the interface which has to be used for color listeners
     * @exception Throws if no type is match The src type should be either be View / Drawable / Url
     */
    fun load(srcType: Any, interfaceType: Any) {
        when (srcType) {
            is View -> loadImagePalette(Util.loadViewToBitmap(srcType), interfaceType)
            is Drawable -> loadImagePalette(Util.drawableToBitmap(srcType), interfaceType)
            is String -> getBitmap(srcType, interfaceType)
            else -> throw IllegalArgumentException("The src type should be either be View / Drawable / Url")

        }

    }


    /**
     * @param image is the bitmap of the view/drawable
     * @param interfaceType is the interface which has to be used for color listeners
     * @return nothing
     */
    private fun loadImagePalette(image: Bitmap, interfaceType: Any) {
        Palette.from(image).generate { palette ->
            vibrant = palette!!.getVibrantColor(defaultValue)
            vibrantLight = palette.getLightVibrantColor(defaultValue)
            vibrantDark = palette.getDarkVibrantColor(defaultValue)
            muted = palette.getMutedColor(defaultValue)
            mutedLight = palette.getLightMutedColor(defaultValue)
            mutedDark = palette.getDarkMutedColor(defaultValue)
            dominantColor = palette.getDominantColor(defaultValue)
            when (interfaceType) {
                /**
                 * @OnImageLoaded shares all color of the Image
                 */
                is OnImageLoaded -> interfaceType.onImageLoaded(
                    colorToHex(vibrant),
                    colorToHex(vibrantLight),
                    colorToHex(vibrantDark),
                    colorToHex(muted),
                    colorToHex(mutedLight),
                    colorToHex(mutedDark),
                    colorToHex(dominantColor)
                )
                /**
                 * @OnVibrantColorGenerated shares vibrant color shade
                 */
                is OnVibrantColorGenerated -> {
                    val colorTextTitle = palette.vibrantSwatch?.titleTextColor
                    val colorRgb = palette.vibrantSwatch?.rgb
                    if (colorTextTitle != null && colorRgb != null) interfaceType.onVibrantColorGenerated(
                        colorToHex(colorTextTitle),
                        colorToHex(colorRgb)
                    )
                }
                /**
                 * @OnVibrantDarkColorGenerated shares vibrant dark color shade
                 */
                is OnVibrantDarkColorGenerated -> {
                    val colorTextTitle = palette.darkVibrantSwatch?.titleTextColor
                    val colorRgb = palette.darkVibrantSwatch?.rgb
                    if (colorTextTitle != null && colorRgb != null) interfaceType.onVibrantDarkColorGenerated(
                        colorToHex(colorTextTitle),
                        colorToHex(colorRgb)
                    )
                }
                /**
                 * @OnMutedDarkColorGenerated shares Mute dark color shade
                 */
                is OnMutedDarkColorGenerated -> {
                    val colorTextTitle = palette.darkMutedSwatch?.titleTextColor
                    val colorRgb = palette.darkMutedSwatch?.rgb
                    if (colorTextTitle != null && colorRgb != null) interfaceType.onMutedDarkColorGenerated(
                        colorToHex(colorTextTitle),
                        colorToHex(colorRgb)
                    )
                }
                /**
                 * @OnMutedLightColorGenerated shares Mute Light color shade
                 */
                is OnMutedLightColorGenerated -> {
                    val colorTextTitle = palette.lightMutedSwatch?.titleTextColor
                    val colorRgb = palette.lightMutedSwatch?.rgb
                    if (colorTextTitle != null && colorRgb != null) interfaceType.onMutedLightColorGenerated(
                        colorToHex(colorTextTitle),
                        colorToHex(colorRgb)
                    )
                }
                /**
                 * @OnVibrantLightColorGenerated shares Vibrant Light color shade
                 */
                is OnVibrantLightColorGenerated -> {
                    val colorTextTitle = palette.lightVibrantSwatch?.titleTextColor
                    val colorRgb = palette.lightVibrantSwatch?.rgb
                    if (colorTextTitle != null && colorRgb != null) interfaceType.onVibrantLightColorGenerated(
                        colorToHex(colorTextTitle),
                        colorToHex(colorRgb)
                    )
                }
                /**
                 * @OnMutedColorGenerated shares Muted color shade
                 */
                is OnMutedColorGenerated -> {
                    val colorTextTitle = palette.mutedSwatch?.titleTextColor
                    val colorRgb = palette.mutedSwatch?.rgb
                    if (colorTextTitle != null && colorRgb != null) interfaceType.onMutedColorGenerated(
                        colorToHex(colorTextTitle),
                        colorToHex(colorRgb)
                    )
                }
                else -> throw IllegalArgumentException("The Interface type not available")
            }
        }

    }

    fun getBitmap(url: String, interfaceType: Any) {
        Picasso.get().load(url).into(object : com.squareup.picasso.Target {
            override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom?) {
                // loaded bitmap is here (bitmap)
                loadImagePalette(bitmap, interfaceType)
            }

            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {}

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {}
        })
    }


}

