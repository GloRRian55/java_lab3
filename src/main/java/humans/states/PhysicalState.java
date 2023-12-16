package humans.states;

import humans.Human;

import java.util.ArrayList;

public enum PhysicalState{
    DEFAULT ("normal"),
    ILLNESS ("illness"),
    WEAKNESS ("weakness");

    PhysicalState(String state){
        this.state = state;
    }
    String state;
    ArrayList<Symptom> symptoms = new ArrayList<>();

    public void addSymptoms(Human human, Symptom[] symptoms){
        for (Symptom symptom : symptoms){
            this.symptoms.add(symptom);
            System.out.printf("%s developed symptoms of the disease, \"%s\"%n", human, symptom);
        }

    }

    public void clearSymptoms(Human human){
        symptoms.removeAll(symptoms.stream().toList());
        System.out.printf("%s got rid of all the symptoms%n", human);
    }

    @Override
    public String toString(){
        return state;
    }

    /*
    We don't override hashCode() method, because in java enum class hashCode is a final method.
    So we also don't override equals() for the same reason.
    */
}
