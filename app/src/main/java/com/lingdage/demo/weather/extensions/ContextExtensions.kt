package com.lingdage.demo.weather.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * author: lingdage
 * date  : 2017-11-09 2:57 PM.
 * github : https://github.com/lingdage
 */
fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)