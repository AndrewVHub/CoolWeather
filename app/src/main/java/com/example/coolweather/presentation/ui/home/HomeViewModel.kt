package com.example.coolweather.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.coolweather.data.constants.ConstantsKey.LOST_INTERNET
import com.example.coolweather.data.models.Weather
import com.example.coolweather.data.models.WeatherModel
import com.example.coolweather.presentation.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val interactor: WeatherInteractor
) : BaseViewModel() {

    private val _weatherInformation = MutableLiveData<WeatherModel>()
    val weatherInformation: LiveData<WeatherModel> = _weatherInformation

    private val _action = MutableLiveData<WeatherAction>()
    val action: LiveData<WeatherAction> = _action

    fun load(lang: String, lat: String, lon: String) {

        viewModelScope.launch {

            try {
                _weatherInformation.postValue(interactor.getWeather(lang, lat, lon))

            } catch (e: Throwable) {
                _action.value = WeatherAction.ShowError(LOST_INTERNET)
            }
            _action.value = WeatherAction.HideLoader
        }
    }

    fun addCity(weather: Weather) {
        viewModelScope.launch {
            try {
                interactor.addCity(weather)
            } catch (e: Throwable) {
            }
        }
    }

    sealed class WeatherAction {
        object HideLoader : WeatherAction()
        data class ShowError(val errorMessage: String) : WeatherAction()
    }
}

