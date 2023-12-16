package groups.types;

public enum GroupState {
    DEFAULT("default"),
    MOVING("moving");

    final String state;

    GroupState(String state) {
        this.state = state;
    }

    @Override
    public String toString(){
        return state;
    }
}
