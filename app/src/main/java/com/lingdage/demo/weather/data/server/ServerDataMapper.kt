package com.lingdage.demo.weather.data.server

import com.lingdage.demo.weather.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit
import com.lingdage.demo.weather.domain.model.Forecast as ModelForecast

/**
 * author: lingdage
 * date  : 2017-11-09 11:22 AM.
 * github : https://github.com/lingdage
 */
class ServerDataMapper {
    fun convertToDomain(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(list))
    }
    
    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }
    
    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(-1, dt, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }
    
    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}