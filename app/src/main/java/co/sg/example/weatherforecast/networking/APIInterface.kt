package co.sg.example.weatherforecast.networking

import co.sg.example.weatherforecast.models.Forecast
import retrofit2.http.GET

interface ApiInterface {

    @GET("data/2.5/forecast?q=London,gb&appid=b6907d289e10d714a6e88b30761fae22")
    suspend fun getWeatherForecast(): Forecast

}