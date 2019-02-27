# ViewColorPicker

A library to generate color palette for view, imageview and image from URL.

### Preview of ViewColorPicker Library
![alt text](https://github.com/MindorksOpenSource/ViewColorGenerator/blob/master/images/image_mock.jpg)


[![Mindorks](https://img.shields.io/badge/mindorks-opensource-blue.svg)](https://mindorks.com/open-source-projects)
[![Mindorks Community](https://img.shields.io/badge/join-community-blue.svg)](https://mindorks.com/join-community)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

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
#### Step 4. To load all (URL/View/Drawable)'s Color Palette
```
viewcolor.load(TAG**, object : OnImageLoaded {
                override fun onImageLoaded( vibrantColor: String, vibrantLightColor: String,  vibrantDarkColor: String, 
                 mutedColor: String, mutedLightColor: String,  mutedDarkColor: String, dominantColor: String) {
                //your logic here
            }

        })
** TAG here is URL/View/Drawable
```