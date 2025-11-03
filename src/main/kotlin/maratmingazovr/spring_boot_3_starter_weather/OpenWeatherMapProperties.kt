package maratmingazovr.spring_boot_3_starter_weather

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Если в подключаемом проекте создадут файл application.yml и там пропишут параметры для openweathermap-starter
 * То будут использованы указанные sdkKey и city
 * Если этого не сделать, то используем текущие default values.
 */
@ConfigurationProperties("openweathermap-starter")
data class OpenWeatherMapProperties(
    var sdkKey: String = "defaultKey",
    var city: String = "defaultCity",
)