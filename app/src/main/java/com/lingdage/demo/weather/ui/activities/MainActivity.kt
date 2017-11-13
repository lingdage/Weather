package com.lingdage.demo.weather.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.lingdage.demo.weather.R
import com.lingdage.demo.weather.domain.commands.RequestForecastCommand
import com.lingdage.demo.weather.extensions.DelegatesExt
import com.lingdage.demo.weather.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), ToolbarManager {
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    val zipCode: Long by DelegatesExt.preference(this, SettingActivity.ZIP_CODE, SettingActivity.DEFAULT_ZIP)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)
        
        
    }
    
    override fun onResume() {
        super.onResume()
        loadForecast()
        
    }
    
    private fun loadForecast() = async() {
        val result = RequestForecastCommand(zipCode).execute()
        uiThread {
            //forecastList.adapter = ForecastListAdapter(result,{toast(it.date+"666")})
            // 最后一个参数为函数 可以移动到圆括号外
            val adapter = ForecastListAdapter(result) {
                startActivity<DetailActivity>(DetailActivity.ID to it.id,
                        DetailActivity.CITY_NAME to result.city)
            }
            forecastList.adapter = adapter
            toolbarTitle = "${result.city} (${result.country})"
        }
    }
}
