package com.peterfabry.trafficlight.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.peterfabry.trafficlight.R

import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.lightsState.observe(this, Observer {
            if (it.greenLight) {
                greenLight.setBackgroundResource(R.drawable.circle_background_green)
            } else {
                greenLight.setBackgroundResource(R.drawable.circle_background_green_off)
            }

            if (it.redLigh) {
                redLight.setBackgroundResource(R.drawable.circle_background_red)
            } else {
                redLight.setBackgroundResource(R.drawable.circle_background_red_off)
            }

            if (it.orangeLight) {
                orangeLight.setBackgroundResource(R.drawable.circle_background_orange)
            } else {
                orangeLight.setBackgroundResource(R.drawable.circle_background_orange_off)
            }
        })

        viewModel.start()
    }

}
