package humans;

import humans.states.ActivityState;
import humans.states.MentalState;
import humans.states.PhysicalState;
import humans.states.Symptom;
import interfaces.*;
import places.Place;

public class Matvey extends Human implements Movable, InsideMovable, Workable, Supportable, Sickable, Layable, Exciteable {
    public Matvey() {
        super("Matvey");
    }

    @Override
    public void think(String minds) {
        Runnable run = () -> System.out.printf("The faithful and only disciple of Ha-Nozri %s's thinking, \"%s\"%n", name, minds);
        runMentalActivity(MentalState.THINKING, run);
    }
    @Override
    public void sayTo(String speech, Human person){
        Runnable run = () -> System.out.printf("The faithful and only disciple of Ha-Nozri %s's saying to %s, \"%s\"%n", name, person.name, speech);
        runActivity(ActivityState.SAYING, run);
    }

    @Override
    public void move(Place startingPlace, Place destination) {
        startingPlace.replaceObject(this);
        System.out.printf("The faithful and only disciple of Ha-Nozri %s's moving from %s to %s%n", name, startingPlace, destination);
        destination.placeObject(this);
    }
    @Override
    public void moveInsidePlace(Place place, String route) {
        System.out.printf("The faithful and only disciple of Ha-Nozri %s's moving inside %s to %s%n", name, place, route);
    }

    @Override
    public void work(Place workingPlace) {
        Runnable run = () -> System.out.printf("The faithful and only disciple of Ha-Nozri %s's working into %s%n", name, workingPlace);
        runActivity(ActivityState.WORKING, run);
    }

    @Override
    public void support(Human helpPerson) {
        System.out.printf("The faithful and only disciple of Ha-Nozri %s's helped the %s%n", name, helpPerson.name);
    }

    @Override
    public void sick(Symptom[] symptoms) {
        System.out.printf("%s is sick%n", this);
        setPhysicalState(PhysicalState.ILLNESS);
        physicalState.addSymptoms(this, symptoms);
    }
    @Override
    public void heal() {
        System.out.printf("%s is recovering%n", this);
        setPhysicalState(PhysicalState.WEAKNESS);
    }

    @Override
    public void lay() {
        System.out.printf("%s is laying\n", this);
        setActivityState(ActivityState.LAYING);
    }
    @Override
    public void standUp() {
        System.out.printf("%s got up\n", this);
        setActivityState(ActivityState.NOTHING);
    }

    @Override
    public void excite() {
        System.out.printf("%s is excited\n", this);
        setMentalState(MentalState.EXCITEMENT);
    }

    public void slip(Human human1, Human human2){
        Runnable run = () -> System.out.printf("%s slip between %s and %s", this, human1, human2);
        runActivity(ActivityState.SLIPPING, run);
    }

    public void predicts(String predict){
        Runnable run = () -> System.out.printf("%s predicts that \"%s\"", this, predict);
        runActivity(ActivityState.PREDICTABLE, run);
    }
}
