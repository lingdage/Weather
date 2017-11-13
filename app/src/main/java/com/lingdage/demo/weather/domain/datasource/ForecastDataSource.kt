package com.lingdage.demo.weather.domain.datasource

import com.lingdage.demo.weather.domain.model.Forecast
import com.lingdage.demo.weather.domain.model.ForecastList

/**
 * author: lingdage
 * date  : 2017-11-09 10:56 AM.
 * github : https://github.com/lingdage
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
    
    fun requestDayForecast(id: Long): Forecast?
    
}