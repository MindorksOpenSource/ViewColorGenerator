package com.mindorks.extension

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.View

internal fun View.toBitmap(): Bitmap {
    measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
    val bitmap = Bitmap.createBitmap(
        measuredWidth,
        measuredHeight,
        Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)
    layout(0, 0, measuredWidth, measuredHeight)
    draw(canvas)
    return bitmap
}

internal fun Drawable.toBitmap(): Bitmap {
    val bitmap: Bitmap? = when {
        intrinsicWidth <= 0 || intrinsicHeight <= 0 -> Bitmap.createBitmap(
            1,
            1,
            Bitmap.Config.ARGB_8888
        ) // Single color bitmap will be created of 1x1 pixel
        else -> Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
    }

    when (this) {
        is BitmapDrawable -> when {
            bitmap != null -> return bitmap
        }
    }

    val canvas = Canvas(bitmap!!)
    setBounds(0, 0, canvas.width, canvas.height)
    draw(canvas)
    return bitmap
}