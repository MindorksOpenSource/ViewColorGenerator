# ViewColorPicker

A library to generate color palette for view, imageview and image from URL.

### Preview of ViewColorPicker Library
![alt text](https://github.com/MindorksOpenSource/ViewColorGenerator/blob/master/images/image_mock.jpg)


[![Mindorks](https://img.shields.io/badge/mindorks-opensource-blue.svg)](https://mindorks.com/open-source-projects)
[![Mindorks Community](https://img.shields.io/badge/join-community-blue.svg)](https://mindorks.com/join-community)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Features of ViewColorPicker
* You can generate color palette of Drawable
* You can generate color palette of View
* You can generate color palette of Image Url.

## Getting Started

##### Step 1. Add the JitPack repository to your Add it in your root `build.gradle` at the end of repositories:

```
allprojects {
    repositories {
   	   maven { url 'https://jitpack.io' }
    }
}
```
##### Step 2. Add the dependency

```
dependencies {
	        implementation 'com.github.MindorksOpenSource:ViewColorGenerator:v0.1'
	}
```

##### Step 3. To use this in Android View File,
```
    val viewcolor = ViewColorGenerator()
```
#### To load all (URL/View/Drawable)'s Color Palette
```
viewcolor.load(TAG**, object : OnImageLoaded {
            override fun onImageLoaded( vibrantColor: String, vibrantLightColor: String,  vibrantDarkColor: String,  mutedColor: String, mutedLightColor: String,  mutedDarkColor: String, dominantColor: String) {
               //YOUR LOGIC HERE
            }

        })
** TAG here is URL/View/Drawable
```

#### To only get Vibrant Dark Color Shade,
```
viewcolor.load(TAG**, object : OnVibrantDarkColorGenerated {
            override fun onVibrantDarkColorGenerated(titleTextColor: String, bodyColor: String) {
               //YOUR LOGIC HERE
            }
        })
** TAG here is URL/View/Drawable
```

#### To only get Vibrant  Color Shade,
```
viewcolor.load(TAG**, object : OnVibrantColorGenerated {
            override fun onVibrantColorGenerated(titleTextColor: String, bodyColor: String) {
               //YOUR LOGIC HERE
            }
        })
** TAG here is URL/View/Drawable
```

#### To only get Muted Dark Color Shade,
```
viewcolor.load(TAG**, object : OnMutedDarkColorGenerated {
            override fun onMutedDarkColorGenerated(titleTextColor: String, bodyColor: String) {
               //YOUR LOGIC HERE
            }
        })
** TAG here is URL/View/Drawable
```

#### To only get Muted Light Color Shade,
```
viewcolor.load(TAG**, object : OnMutedLightColorGenerated {
            override fun onMutedLightColorGenerated(titleTextColor: String, bodyColor: String) {
               //YOUR LOGIC HERE
            }
        })
** TAG here is URL/View/Drawable
```

#### To only get Vibrant Light Color Shade,
```
viewcolor.load(TAG**, object : OnVibrantLightColorGenerated {
            override fun onVibrantLightColorGenerated(titleTextColor: String, bodyColor: String) {
               //YOUR LOGIC HERE
            }
        })
** TAG here is URL/View/Drawable
```

#### To only get Muted Color Shade,
```
viewcolor.load(TAG**, object : OnMutedColorGenerated {
            override fun onMutedColorGenerated(titleTextColor: String, bodyColor: String) {
               //YOUR LOGIC HERE
            }
        })
** TAG here is URL/View/Drawable
```
## If this library helps you in anyway, show your love :heart: by putting a :star: on this project :v:

[Check out Mindorks awesome open source projects here](https://mindorks.com/open-source-projects)

Contributor
 * [Himanshu Singh](https://github.com/hi-manshu)
 * [Sutirth](https://github.com/sutirth)
 
 ### ViewColorPicker is made on top of,
 * [Picasso](https://github.com/square/picasso)
 * [Palette API](https://developer.android.com/training/material/palette-colors)