package com.lingdage.demo.weather.extensions

import org.junit.Assert
import org.junit.Test

/**
 * author: lingdage
 * date  : 2017-11-10 7:28 PM.
 * github : https://github.com/lingdage
 */
class ExtensionKtTests {
    @Test
    fun toDateString() {
        Assert.assertEquals("Oct 20, 2015", 1445275635000L.toDateString())
    }

}