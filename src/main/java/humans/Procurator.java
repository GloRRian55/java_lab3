package humans;

import humans.states.ActivityState;
import humans.states.MentalState;

public class Procurator extends Human{
    public Procurator() {
        super("procurator");
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

    public void announce(String announcement) {
        Runnable run = () -> System.out.printf("%s announces that %s%n", name, announcement);
        runActivity(ActivityState.SAYING, run);
    }
}
