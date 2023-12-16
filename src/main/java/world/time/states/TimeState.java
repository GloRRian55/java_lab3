package world.time.states;

public enum TimeState {
    MORNING("morning"),
    DAY("day"),
    EVENING("evening"),
    NIGHT("night");

    final String time;
    TimeState(String time){
        this.time = time;
    }

    @Override
    public String toString() {
        return time;
    }
}
