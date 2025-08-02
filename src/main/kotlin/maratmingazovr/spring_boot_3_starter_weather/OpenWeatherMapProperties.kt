package maratmingazovr.spring_boot_3_starter_weather

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("openweathermap-starter")
data class OpenWeatherMapProperties(
    var sdkKey: String = "defaultKey",
    var city: String = "defaultCity",
)