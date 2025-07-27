package com.maratmingazov.spring_boot_3_starter_weather

import com.github.prominence.openweathermap.api.OpenWeatherMapClient
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(OpenWeatherMapProperties::class)
class OpenWeatherMapAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    fun openWeatherMapClient(properties: OpenWeatherMapProperties) = OpenWeatherMapClient(properties.sdkKey)

    @Bean
    @ConditionalOnMissingBean
    fun weatherService(
        properties: OpenWeatherMapProperties,
        client: OpenWeatherMapClient,
    ): WeatherService {
        return WeatherService(properties.city, client)
    }
}