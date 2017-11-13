package com.lingdage.demo.weather.domain.datasource

import com.lingdage.demo.weather.data.db.ForecastDb
import com.lingdage.demo.weather.data.server.ForecastServer
import com.lingdage.demo.weather.domain.model.Forecast
import com.lingdage.demo.weather.domain.model.ForecastList
import com.lingdage.demo.weather.extensions.firstResult

/**
 * author: lingdage
 * date  : 2017-11-09 10:57 AM.
 * github : https://github.com/lingdage
 */
class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {
    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy { listOf(ForecastDb(), ForecastServer())}
    }
    
    
    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size() >= days) res else null
    }
    
    
    fun requestForecast(id:Long): Forecast = requestToSources { it.requestDayForecast(id) }
    
    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS
    
    private fun <T : Any> requestToSources(f: (ForecastDataSource) -> T?): T = sources.firstResult { f(it) }
}