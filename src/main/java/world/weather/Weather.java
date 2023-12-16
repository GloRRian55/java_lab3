package world.weather;

import world.weather.states.TemperatureState;
import world.weather.states.WeatherState;

public class Weather {
    public Weather(WeatherState weather, TemperatureState temperature){
        this.weather = weather;
        this.temperature = temperature;
    }

    private WeatherState weather;
    private TemperatureState temperature;

    public WeatherState getWeather() {
        return weather;
    }
    public void setWeather(WeatherState weather) {
        System.out.printf("The weather has changed, now it's %s outside%n", weather);
        this.weather = weather;
    }

    public TemperatureState getTemperature() {
        return temperature;
    }
    public void setTemperature(TemperatureState temperature) {
        System.out.printf("It's getting %s outside", temperature);
        this.temperature = temperature;
    }
}
