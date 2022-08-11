package com.example.coolweather.presentation.ui.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.coolweather.data.constants.ConstantsKey.NO_PERMISSION
import com.example.coolweather.databinding.FragmentHomeBinding
import com.example.coolweather.presentation.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    LocationListener {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var locationManager: LocationManager
    private val locationPermissionCode = 2

    private val locationPermissionRequest =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { result: Map<String, Boolean> ->
            val fineLocationGranted: Boolean?
            val coarseLocationGranted: Boolean?
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                fineLocationGranted = result.getOrDefault(
                    Manifest.permission.ACCESS_FINE_LOCATION, false
                )
                coarseLocationGranted = result.getOrDefault(
                    Manifest.permission.ACCESS_COARSE_LOCATION, false
                )
            } else {
                fineLocationGranted = result[Manifest.permission.ACCESS_FINE_LOCATION]
                coarseLocationGranted = result[Manifest.permission.ACCESS_COARSE_LOCATION]
            }
            if (fineLocationGranted != null && fineLocationGranted || coarseLocationGranted != null && coarseLocationGranted) {
                getLocation()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(NO_PERMISSION),
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    override fun FragmentHomeBinding.initialize() {
        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )

        val adapter = HomeAdapter()
        recyclerWeather.adapter = adapter

        viewModel.weatherInformation.observe(viewLifecycleOwner) {

            weatherImage.setImageResource(it.data.first().image)
            nameCity.text = it.data.first().cityName
            temperatureValue.text = it.data.first().temp.toInt().toString()
            description.text = it.data.first().weather
            pressureValue.text = it.data.first().pressure.toString() + " мБар"
            humidityValue.text = it.data.first().humidity.toString() + "%"
            windValue.text = it.data.first().windSpeed.toString() + " км/ч"
            sunriseValue.text = it.data.first().sunrise
            sunsetValue.text = it.data.first().sunset

            adapter.collection = it.data

            viewModel.addCity(it.data[0])
        }

        viewModel.action.observe(viewLifecycleOwner){ action ->
            when(action){
                is HomeViewModel.WeatherAction.HideLoader -> {
                    contentWeather.isVisible = true
                    progressBar.isVisible = false
                    swipeRefresh.isRefreshing = false
                }
                is HomeViewModel.WeatherAction.ShowError -> Toast.makeText(
                    context,
                    action.errorMessage,
                    Toast.LENGTH_LONG
                ).show()
            }
        }


    }

    /**
     * Get location from GPS
     */
    private fun getLocation() {
        context?.let {
            val mLocationManager = it.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            if (ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    it, Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
        }

    }

    override fun onLocationChanged(location: Location) {
        viewModel.load(
            Locale.getDefault().language,
            location.latitude.toString(),
            location.longitude.toString()
        )
    }

}