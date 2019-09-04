package com.peterfabry.trafficlight.ui.main

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.xml.parsers.FactoryConfigurationError


class MainViewModel : ViewModel() {
    val lightsState = MutableLiveData<LightsState>()
    val handler = Handler()

    val red = LightsState(true,false,false)
    val orange = LightsState(false,true,false)
    val green = LightsState(false,false,true)

    fun  start() {
        changeLights()
    }

    fun changeLights(changeTo : LightsState? = null, current : LightsState? = null) {
        if (changeTo == red) {
            lightsState.postValue(red)
            Log.d("changeLights","menime na red")
            handler.postDelayed({ changeLights(orange, red) },4000)
        } else if (changeTo == orange && current == red) {
            lightsState.postValue(orange)
            Log.d("changeLights","menime na orange z red")
            handler.postDelayed({ changeLights(green) },1000)
        } else if (changeTo == orange && current == green) {
            lightsState.postValue(orange)
            Log.d("changeLights","menime na orange z green")
            handler.postDelayed({ changeLights(red) },1000)
        } else if (changeTo == green) {
            lightsState.postValue(green)
            Log.d("changeLights","menime na Green")
            handler.postDelayed({ changeLights(orange, green) },4000)
        } else {
            lightsState.postValue(red)
            Log.d("changeLights","nothing - default state red light")
            handler.postDelayed({ changeLights(orange, red) },4000)
        }
    }
}

data class LightsState(var redLigh: Boolean = false, var orangeLight: Boolean = false, var greenLight: Boolean = false)