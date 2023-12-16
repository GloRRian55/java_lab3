package world;

import exception.ObjectWithoutPlaceException;
import groups.Group;
import humans.Human;
import places.Place;
import world.time.Time;
import world.time.states.TimeState;
import world.weather.Weather;
import world.weather.states.TemperatureState;
import world.weather.states.WeatherState;

import java.util.ArrayList;
import java.util.List;

public class World {
    public World(Place[] places) {
        this.time = new Time(TimeState.MORNING);
        this.weather = new Weather(WeatherState.CLEAR, TemperatureState.WARM);
        this.places.addAll(List.of(places));
    }

    public World(TimeState time, WeatherState weather, TemperatureState temperature) {
        this.time = new Time(time);
        this.weather = new Weather(weather, temperature);
    }

    public Time time;
    public Weather weather;

    ArrayList<Place> places = new ArrayList<>();

    public Place getLocation(Human human) throws ObjectWithoutPlaceException {
        for (Place place : places) if (place.contains(human)) return place;
        throw new ObjectWithoutPlaceException(String.format("%s object doesn't have place", human));
    }

    public Place getLocation(Group group) throws ObjectWithoutPlaceException {
        for (Place place : places) if (place.contains(group)) return place;
        throw new ObjectWithoutPlaceException(String.format("%s object doesn't have place", group));
    }
}
