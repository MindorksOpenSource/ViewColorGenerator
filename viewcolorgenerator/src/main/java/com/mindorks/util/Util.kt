package com.mindorks.util

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable


object Util {
    fun loadViewToBitmap(view: View): Bitmap {
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        val bitmap = Bitmap.createBitmap(
            view.measuredWidth,
            view.measuredHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.draw(canvas)
        return bitmap

    }

    fun drawableToBitmap(drawable: Drawable): Bitmap {
        var bitmap: Bitmap? = when {
            drawable.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0 -> Bitmap.createBitmap(
                1,
                1,
                Bitmap.Config.ARGB_8888
            ) // Single color bitmap will be created of 1x1 pixel
            else -> Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        }

        when (drawable) {
            is BitmapDrawable -> when {
                drawable.bitmap != null -> return drawable.bitmap
            }
        }

        val canvas = Canvas(bitmap!!)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }


    fun colorToHex(color: Int): String {
        val alpha = android.graphics.Color.alpha(color)
        val blue = android.graphics.Color.blue(color)
        val green = android.graphics.Color.green(color)
        val red = android.graphics.Color.red(color)

        val alphaHex = to00Hex(alpha)
        val blueHex = to00Hex(blue)
        val greenHex = to00Hex(green)
        val redHex = to00Hex(red)
        val str = StringBuilder("#")
        str.append(alphaHex)
        str.append(blueHex)
        str.append(greenHex)
        str.append(redHex)

        return str.toString()
    }

    private fun to00Hex(value: Int): String {
        val hex = "00" + Integer.toHexString(value)
        return hex.substring(hex.length - 2, hex.length)
    }
}