package com.lingdage.demo.weather.domain.commands

import com.lingdage.demo.weather.domain.datasource.ForecastProvider
import com.lingdage.demo.weather.domain.model.Forecast

/**
 * author: lingdage
 * date  : 2017-11-09 2:32 PM.
 * github : https://github.com/lingdage
 */
class RequestDayForecastCommand(
        val id: Long,
        val forecastProvider: ForecastProvider = ForecastProvider() ) : Command<Forecast> {
    
    override fun execute(): Forecast = forecastProvider.requestForecast(id)
}