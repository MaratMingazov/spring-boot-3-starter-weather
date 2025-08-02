package maratmingazovr.spring_boot_3_starter_weather

import com.github.prominence.openweathermap.api.OpenWeatherMapClient
import com.github.prominence.openweathermap.api.enums.Language
import com.github.prominence.openweathermap.api.enums.UnitSystem


class WeatherService(
    private val defaultCity: String,
    private val openWeatherClient: OpenWeatherMapClient,
) {

    fun getTemperature() : String {
         return getTemperature(defaultCity)
    }

    fun getTemperature(city: String) : String {
        return openWeatherClient
            .currentWeather()
            .single()
            .byCityName(city)
            .language(Language.ENGLISH)
            .unitSystem(UnitSystem.IMPERIAL)
            .retrieve()
            .asJSON()
    }
}