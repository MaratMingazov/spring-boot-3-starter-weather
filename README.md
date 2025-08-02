# 🌦️ Spring Boot 3 Starter — Weather (OpenWeatherMap)

A lightweight Spring Boot 3 starter for retrieving current weather data using the [OpenWeatherMap API](https://openweathermap.org/), with simple auto-configuration and YAML-based setup.

---

## 🚀 Quick Start

### 1. Add the dependency

#### Gradle (Kotlin DSL)
```kotlin
implementation("maratmingazovr:spring-boot-3-starter-weather:1.0.0")
```

#### Maven
```xml
<dependency>
    <groupId>maratmingazovr</groupId>
    <artifactId>spring-boot-3-starter-weather</artifactId>
    <version>1.0.0</version>
</dependency>
```

> Ensure that either `mavenCentral()` or `mavenLocal()` is configured depending on how you publish the starter.

---

### 2. Configure your `application.yml`

```yaml
openweathermap-starter:
  sdkKey: your-api-key
  city: Yerevan
```

| Property   | Description                                          |
|------------|------------------------------------------------------|
| `sdkKey`   | 🔐 Your API key from [openweathermap.org](https://openweathermap.org/api) |
| `city`     | 🌍 Default city to query the weather for             |

---

### 3. Inject and use the service

```kotlin
import maratmingazovr.spring_boot_3_starter_weather.WeatherService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WeatherController(private val weatherService: WeatherService) {

    @GetMapping("/weather")
    fun currentWeather(): String = weatherService.getTemperature()

    @GetMapping("/weather/moscow")
    fun moscowWeather(): String = weatherService.getTemperature("Moscow")
}
```

---

## ⚙️ What this starter does

- Automatically configures an instance of `OpenWeatherMapClient` from the [openweathermap-api (v2.4.1)](https://github.com/Prominence/openweathermap-java-api) library
- Registers a ready-to-use `WeatherService` bean
- Supports configuration via `application.yml` using Spring Boot's `@ConfigurationProperties`
- Loads default properties via an `EnvironmentPostProcessor` if needed

---

## 🔧 Internals

Example `WeatherService` class:
```kotlin
class WeatherService(
    private val defaultCity: String,
    private val openWeatherClient: OpenWeatherMapClient,
) {
    fun getTemperature(): String {
        return getTemperature(defaultCity)
    }

    fun getTemperature(city: String): String {
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
```

---

## 🧪 Requirements

- Java 17+
- Spring Boot 3.x
- API key from [OpenWeatherMap](https://openweathermap.org/api)

---

## 🛠️ Building and Publishing Locally

To test the starter locally:

```bash
./gradlew publishToMavenLocal
```

Then make sure your consuming project has:

```kotlin
repositories {
    mavenLocal()
    mavenCentral()
}
```

---

## 📄 License

MIT © Marat Mingazov
