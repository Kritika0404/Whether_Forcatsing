package co.sg.example.weatherforecast.repositories

import co.sg.example.weatherforecast.models.Forecast
import co.sg.example.weatherforecast.networking.ApiClient
import co.sg.example.weatherforecast.networking.ApiInterface
import co.sg.example.weatherforecast.networking.Resource
import co.sg.example.weatherforecast.networking.ResponseHandler
import org.koin.dsl.module

val forecastListRepositoryModule = module {
    factory { ForecastListRepository() }
}

class ForecastListRepository {

    suspend fun fetchForecastList(): Resource<Forecast> {
        val client: ApiInterface = ApiClient.getClient
        val responseHandler = ResponseHandler()
        return try {
            val response = client.getWeatherForecast()
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

}
