package com.lingdage.demo.weather.data.server

import com.google.gson.Gson
import java.net.URL as javaURL

/**
 * author: lingdage
 * date  : 2017-11-08 9:56 AM.
 * github : https://github.com/lingdage
 */

class ForecastByZipCodeRequest(val zipCode: Long, val gson: Gson = Gson()) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${URL}&APPID=${APP_ID}&q="
    }
    
    fun execute(): ForecastResult {
        val forecastJsonStr = javaURL(COMPLETE_URL + zipCode).readText()
        return gson.fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}