package humans;

import humans.states.ActivityState;
import humans.states.MentalState;

public class Owner extends Human {
    public Owner() {
        super("owner");
    }

    @Override
    public void think(String minds) {
        Runnable run = () -> System.out.printf("%s of the garden is thinking, \"%s\"%n", name, minds);
        runMentalActivity(MentalState.THINKING, run);
    }
    @Override
    public void sayTo(String speech, Human person) {
        Runnable run = () -> System.out.printf("%s of the garden is saying, \"%s\", to %s%n", name, speech, person.name);
        runActivity(ActivityState.SAYING, run);
    }
}
