package com.peterfabry.trafficlight

import com.peterfabry.trafficlight.ui.main.LightsState
import com.peterfabry.trafficlight.ui.main.MainViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun correctColors() {
        val red = LightsState(true,false,false)
        val mainViewModel = MainViewModel()

        assertEquals(mainViewModel.red,red)

    }
}
