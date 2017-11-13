package com.lingdage.demo.weather.extensions

import android.view.View

/**
 * author: lingdage
 * date  : 2017-11-09 3:59 PM.
 * github : https://github.com/lingdage
 */
fun View.slideExit() {
    if (translationY == 0f) animate().translationY(-height.toFloat())
}

fun View.slideEnter() {
    if (translationY < 0f) animate().translationY(0f)
}