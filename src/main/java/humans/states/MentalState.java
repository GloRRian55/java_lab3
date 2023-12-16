package humans.states;

public enum MentalState {
    DEFAULT ("normal"),
    THINKING ("thinking"),
    EXCITEMENT ("excitement");

    MentalState(String state){
        this.state = state;
    }
    String state;

    @Override
    public String toString(){
        return state;
    }

    /*
    We don't override hashCode() method, because in java enum class hashCode is a final method.
    So we also don't override equals() for the same reason.
    */
}
