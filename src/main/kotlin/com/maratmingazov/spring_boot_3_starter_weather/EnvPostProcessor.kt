package com.maratmingazov.spring_boot_3_starter_weather

import org.springframework.boot.SpringApplication
import org.springframework.boot.env.EnvironmentPostProcessor
import org.springframework.boot.env.YamlPropertySourceLoader
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.core.io.ClassPathResource

class EnvPostProcessor(
    private val propertySourceLoader: YamlPropertySourceLoader = YamlPropertySourceLoader()
): EnvironmentPostProcessor {

    override fun postProcessEnvironment(
        environment: ConfigurableEnvironment?,
        application: SpringApplication?,
    ) {
        val resource = ClassPathResource("application.yaml")
        val propertySource = propertySourceLoader.load("openweathermap-starter", resource)
        environment?.propertySources?.addLast(propertySource[0])
    }
}