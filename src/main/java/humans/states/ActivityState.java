package humans.states;


public enum ActivityState {
    NOTHING ("nothing"),
    WORKING ("working"),
    SAYING ("saying"),
    GOING ("going"),
    PREDICTABLE("predicting"),
    SLIPPING("sliping"),
    LAYING ("laying");


    ActivityState(String status){
        this.state = status;
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
