package humans.states;

public enum Symptom {
    SHAKING("shaking"),
    HEAT("body was filled with fire"),
    CHATTER_TEETH("began to chatter his teeth "),
    THIRST("asking for a drink every minute");

    Symptom(String symptom){
        this.symptom = symptom;
    };

    String symptom;

    @Override
    public String toString(){
        return symptom;
    }
}
