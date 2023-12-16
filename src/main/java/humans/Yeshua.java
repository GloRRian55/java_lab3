package humans;

import humans.states.ActivityState;
import humans.states.MentalState;
import interfaces.InsideMovable;
import interfaces.Movable;
import interfaces.Supportable;
import interfaces.Workable;
import places.Place;

public class Yeshua extends Human implements Movable, InsideMovable, Workable, Supportable {
    public Yeshua() {
        super("Yeshua");
    }

    @Override
    public void think(String minds) {
        Runnable run = () -> System.out.printf("%s Ha-Nozri's thinking, \"%s\"%n", name, minds);
        runMentalActivity(MentalState.THINKING, run);
    }
    @Override
    public void sayTo(String speech, Human person) {
        Runnable run = () -> System.out.printf("%s Ha-Nozri's saying to %s, \"%s\"%n", name, person.name, speech);
        runActivity(ActivityState.SAYING, run);
    }

    @Override
    public void move(Place startingPlace, Place destination) {
        startingPlace.replaceObject(this);
        System.out.printf("%s Ha-Nozri's moving from %s to %s%n", name, startingPlace, destination);
        destination.placeObject(this);
    }
    @Override
    public void moveInsidePlace(Place place, String route) {
        System.out.printf("%s Ha-Nozri's moving inside %s to %s%n", name, place, route);
    }

    @Override
    public void support(Human helpPerson) {
        System.out.printf("%s Ha-Nozri's helped the %s%n", name, helpPerson.name);
    }

    @Override
    public void work(Place workingPlace) {
        Runnable run = () -> System.out.printf("%s Ha-Nozri's working into %s%n", name, workingPlace);
        runActivity(ActivityState.WORKING, run);
    }

    public void hurry(Place destination) {
        System.out.printf("%s is in a hurry to %s%n", this, destination);
    }
}
