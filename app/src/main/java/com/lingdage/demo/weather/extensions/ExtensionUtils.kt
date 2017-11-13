package com.lingdage.demo.weather.extensions

import java.text.DateFormat
import java.util.*

/**
 * author: lingdage
 * date  : 2017-11-09 2:56 PM.
 * github : https://github.com/lingdage
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}