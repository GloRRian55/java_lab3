package world.time;

import world.time.states.TimeState;

public class Time {
    public Time(TimeState time){
        this.time = time;
    }
    private TimeState time;

    public TimeState getTime() {
        return time;
    }
    public void setTime(TimeState time) {
        System.out.printf("Time is passing, %s is coming\n", time);
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("It's %s now\n", time);
    }
}
