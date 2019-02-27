package com.mindorks.sample

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mindorks.ViewColorGenerator
import com.mindorks.`interface`.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewcolor = ViewColorGenerator()
        viewcolor.load(resources.getDrawable(R.drawable.ic_search), object : OnImageLoaded {
            override fun onImageLoaded(
                vibrantColor: String,
                vibrantLightColor: String,
                vibrantDarkColor: String,
                mutedColor: String,
                mutedLightColor: String,
                mutedDarkColor: String,
                dominantColor: String
            ) {

            }

        })
        viewcolor.load(resources.getDrawable(R.drawable.ic_search), object : OnVibrantDarkColorGenerated {
            override fun onVibrantDarkColorGenerated(titleTextColor: String, bodyColor: String) {
                background.setBackgroundColor(Color.parseColor(bodyColor))
                backgroundText.setTextColor(Color.parseColor(titleTextColor))


            }
        })

        viewcolor.load((resources.getDrawable(R.drawable.ic_search)), object : OnVibrantColorGenerated {
            override fun onVibrantColorGenerated(titleTextColor: String, bodyColor: String) {
                backgroundTwo.setBackgroundColor(Color.parseColor(bodyColor))
                backgroundTextTwo.setTextColor(Color.parseColor(titleTextColor))
            }
        })
        viewcolor.load((resources.getDrawable(R.drawable.ic_search)), object : OnMutedDarkColorGenerated {
            override fun onMutedDarkColorGenerated(titleTextColor: String, bodyColor: String) {
                backgroundThree.setBackgroundColor(Color.parseColor(bodyColor))
                backgroundTextThree.setTextColor(Color.parseColor(titleTextColor))
            }
        })
        viewcolor.load((resources.getDrawable(R.drawable.ic_search)), object : OnMutedLightColorGenerated {
            override fun onMutedLightColorGenerated(titleTextColor: String, bodyColor: String) {
                backgroundFour.setBackgroundColor(Color.parseColor(bodyColor))
                backgroundTextFour.setTextColor(Color.parseColor(titleTextColor))
            }
        })
        viewcolor.load((resources.getDrawable(R.drawable.ic_search)), object : OnVibrantLightColorGenerated {
            override fun onVibrantLightColorGenerated(titleTextColor: String, bodyColor: String) {
                backgroundFive.setBackgroundColor(Color.parseColor(bodyColor))
                backgroundTextFive.setTextColor(Color.parseColor(titleTextColor))
            }
        })
        viewcolor.load((resources.getDrawable(R.drawable.ic_search)), object : OnMutedColorGenerated {
            override fun onMutedColorGenerated(titleTextColor: String, bodyColor: String) {
                backgroundSix.setBackgroundColor(Color.parseColor(bodyColor))
                backgroundTextSix.setTextColor(Color.parseColor(titleTextColor))
            }
        })

    }
}
