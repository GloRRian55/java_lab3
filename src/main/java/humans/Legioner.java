package humans;

import humans.states.ActivityState;
import humans.states.MentalState;

public class Legioner extends Human implements Cloneable{
    public Legioner() {
        super("legioner");
    }

    @Override
    public void think(String minds) {
        Runnable run = () -> System.out.printf("%s is thinking, \"%s\"%n", name, minds);
        runMentalActivity(MentalState.THINKING, run);
    }
    @Override
    public void sayTo(String speech, Human person) {
        Runnable run = () -> System.out.printf("%s is saying, \"%s\", to %s%n", name, speech, person.name);
        runActivity(ActivityState.SAYING, run);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
