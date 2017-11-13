package com.lingdage.demo.weather.data.db

/**
 * author: lingdage
 * date  : 2017-11-08 4:47 PM.
 * github : https://github.com/lingdage
 */
object CityForecastTable{
    val NAME = "CityForecast"
    val ID = "_id"
    val CITY = "city"
    val COUNTRY = "country"
}

object DayForecastTable {
    val NAME = "DayForecast"
    val ID = "_id"
    val DATE = "date"
    val DESCRIPTION = "description"
    val HIGH = "high"
    val LOW = "low"
    val ICON_URL = "iconUrl"
    val CITY_ID = "cityId"
}