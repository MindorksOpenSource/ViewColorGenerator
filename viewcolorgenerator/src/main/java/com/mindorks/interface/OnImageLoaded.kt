package com.mindorks.`interface`

/**
 * @OnImageLoaded interface loads all the color shades
 */
 interface OnImageLoaded {
    fun onImageLoaded(
        vibrantColor: String,
        vibrantLightColor: String,
        vibrantDarkColor: String,
        mutedColor: String,
        mutedLightColor: String,
        mutedDarkColor: String,
        dominantColor: String
    )

}