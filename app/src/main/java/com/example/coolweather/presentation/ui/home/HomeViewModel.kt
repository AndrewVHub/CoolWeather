package com.example.coolweather.presentation.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.coolweather.data.models.WeatherModel
import com.example.coolweather.data.models.WeatherResponse
import com.example.coolweather.presentation.ui.base.BaseViewModel
import dagger.Module
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val interactor: WeatherInteractor
): BaseViewModel() {

    private val _sunInformation = MutableLiveData<List<WeatherModel>>()
    val sunInformation: LiveData<List<WeatherModel>> = _sunInformation



    init {
        load()
    }

    fun load(){

        viewModelScope.launch {
            try {
                _sunInformation.postValue(interactor.getSunInformation())

            } catch (e: Throwable) {
                Log.e("E", e.message.toString())
            }
        }

    }

    //val date = SimpleDateFormat("HH:mm").format(Date (1658759567*1000L))

}