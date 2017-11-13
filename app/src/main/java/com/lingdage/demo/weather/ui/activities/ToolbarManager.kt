package com.lingdage.demo.weather.ui.activities

import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.lingdage.demo.weather.R
import com.lingdage.demo.weather.extensions.slideEnter
import com.lingdage.demo.weather.extensions.slideExit
import com.lingdage.demo.weather.ui.App
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * author: lingdage
 * date  : 2017-11-09 3:13 PM.
 * github : https://github.com/lingdage
 */
interface ToolbarManager {
    val toolbar: Toolbar
    
    var toolbarTitle:String
        get() = toolbar.title.toString()
        set(value) { toolbar.title = value }
    
    fun initToolbar(){
        toolbar.inflateMenu(R.menu.main6)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_settings -> toolbar.context.startActivity<SettingActivity>()
                else -> App.instance.toast("unknown option")
            }
            true
        }
    }
    
    fun enableHomeAsUp(up: () -> Unit){
        toolbar.navigationIcon = createUpDrawable()
        toolbar.setNavigationOnClickListener{ up()}
    }
    
    private fun createUpDrawable() = DrawerArrowDrawable(toolbar.context).apply { progress = 1f }
    
    fun attachToScroll(recyclerView: RecyclerView){
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (dy > 0) toolbar.slideExit() else toolbar.slideEnter()
            }
        })
        
//        recyclerView.addOnScrollListener({(recyclerView,,dy)->{}})
    }
}