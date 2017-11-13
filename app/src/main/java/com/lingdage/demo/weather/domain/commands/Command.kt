package com.lingdage.demo.weather.domain.commands


/**
 * author: lingdage
 * date  : 2017-11-08 11:18 AM.
 * github : https://github.com/lingdage
 */
public interface Command<T> {
    fun execute():T
}


