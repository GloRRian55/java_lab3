package world.weather.states;

public enum WeatherState {
    CLEAR ("clear");
    private final String state;

    WeatherState(String state){
        this.state = state;
    }

    @Override
    public String toString() {
        return state;
    }

}
