package interfaces;

import humans.states.Symptom;

public interface Sickable {
    void sick(Symptom[] symptoms);
    void heal();
}
