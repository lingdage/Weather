package com.lingdage.demo.weather.domain.commands

import com.lingdage.demo.weather.domain.datasource.ForecastProvider
import com.lingdage.demo.weather.domain.model.ForecastList

/**
 * author: lingdage
 * date  : 2017-11-08 1:22 PM.
 * github : https://github.com/lingdage
 */
class RequestForecastCommand(
        private val zipCode: Long,
        private val forecastProvider: ForecastProvider = ForecastProvider()) : Command<ForecastList> {
    
    companion object {
        val DAYS = 7
        
    }
    
    override fun execute(): ForecastList = forecastProvider.requestByZipCode(zipCode, DAYS)
    
}