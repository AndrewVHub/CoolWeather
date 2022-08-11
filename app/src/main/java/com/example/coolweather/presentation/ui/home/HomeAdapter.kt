package com.example.coolweather.presentation.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coolweather.R
import com.example.coolweather.data.models.Weather
import com.example.coolweather.databinding.WeatherItemBinding
import java.text.SimpleDateFormat
import java.util.*

class HomeAdapter :RecyclerView.Adapter<HomeAdapter.WeatherViewHolder>(){

    var collection: List<Weather>? = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class WeatherViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = WeatherItemBinding.bind(view)
        fun bind(item: Weather) = with(binding){

            date.text = SimpleDateFormat("dd/MM - HH:mm").format(Date (item.ts*1000L))
            weatherImageItem.setImageResource(item.image)
            temperatureValue.text = item.temp.toInt().toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        collection.let{
            val item = it?.get(position)
            if (item != null) {
                holder.bind(item)
            }
        }
    }
    override fun getItemCount(): Int = collection?.size?: 0

}