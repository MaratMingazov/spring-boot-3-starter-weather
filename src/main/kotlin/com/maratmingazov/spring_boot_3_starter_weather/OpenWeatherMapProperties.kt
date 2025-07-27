package com.maratmingazov.spring_boot_3_starter_weather

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("openweathermap-starter")
data class OpenWeatherMapProperties(
    val sdkKey: String,
    val city: String,
)