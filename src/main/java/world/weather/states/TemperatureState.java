package world.weather.states;

public enum TemperatureState {
    WARM ("warm");

    private final String temperature;

    TemperatureState(String temperature){
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return temperature;
    }
}
