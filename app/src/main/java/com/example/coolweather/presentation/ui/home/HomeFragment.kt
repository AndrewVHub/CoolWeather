package com.example.coolweather.presentation.ui.home

import android.util.Log
import androidx.fragment.app.viewModels
import com.example.coolweather.databinding.FragmentHomeBinding
import com.example.coolweather.presentation.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate){

    private val viewModel: HomeViewModel by viewModels()

    override fun FragmentHomeBinding.initialize() {

        viewModel.sunInformation.observe(viewLifecycleOwner){

            temperatureValue.text = it.first().temp.toInt().toString()
            conditionValue.text = it.first().weather.description
            pressureValue.text = it.first().pres.toString() + " mBar"
            moistureValue.text = it.first().rh.toString() + "%"
            windSpeedValue.text = it.first().wind_spd.toString() + " km/h"
            sunrise.text = it.first().sunrise_ts
            sunset.text = it.first().sunset_ts

        }
    }

}