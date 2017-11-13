package com.lingdage.demo.weather.data.server

import com.lingdage.demo.weather.data.db.ForecastDb
import com.lingdage.demo.weather.domain.datasource.ForecastDataSource
import com.lingdage.demo.weather.domain.model.Forecast
import com.lingdage.demo.weather.domain.model.ForecastList

/**
 * author: lingdage
 * date  : 2017-11-09 11:21 AM.
 * github : https://github.com/lingdage
 */
class ForecastServer (val dataMapper:ServerDataMapper = ServerDataMapper(),
                      val forecastDb: ForecastDb = ForecastDb()):ForecastDataSource{
    override fun requestDayForecast(id: Long): Forecast? = throw UnsupportedOperationException()
    
    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result  = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }
}