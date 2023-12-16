package humans;

import exception.StateAlreadyRunningException;
import humans.states.*;

import java.util.Objects;

public abstract class Human {
    protected Human(String name) {
        this.name = name;
    }
    public final String name;

    protected ActivityState activityState = ActivityState.NOTHING;
    protected MentalState mentalState = MentalState.DEFAULT;
    protected PhysicalState physicalState = PhysicalState.DEFAULT;

    public ActivityState getActivityState(){
        return activityState;
    }
    public MentalState getMentalState() {
        return mentalState;
    }
    public PhysicalState getPhysicalState() {
        return physicalState;
    }

    protected void setActivityState(ActivityState newState){
        activityState = newState;
        System.out.printf("%s now does %s\n", this, activityState);
    }
    protected void setMentalState(MentalState newState){
        mentalState = newState;
        System.out.printf("%s's mental state now is %s\n", this, physicalState);
    }
    protected void setPhysicalState(PhysicalState newState){
        physicalState = newState;
        System.out.printf("%s's physical state now is %s\n", this, mentalState);
    }

    protected void runActivity(ActivityState activityState, Runnable activity){
        if (this.activityState == activityState){
            throw new StateAlreadyRunningException(
                    String.format("Activity %s is already using by %s 'Human' object", activityState, this)
            );
        }
        ActivityState originalActivity = this.activityState;
        setActivityState(activityState);
        activity.run();
        setActivityState(originalActivity);
    }
    protected void runMentalActivity(MentalState mentalState, Runnable activity){
        if (this.mentalState == mentalState){
            throw new StateAlreadyRunningException(
                    String.format("Mental activity %s is already using by %s 'Human' object", activityState, this)
            );
        }
        MentalState originalActivity = this.mentalState;
        setMentalState(mentalState);
        activity.run();
        setMentalState(originalActivity);
    }
    public abstract void think(String minds);
    public abstract void sayTo(String speech, Human person);

    @Override
    public int hashCode() {
        return Objects.hash(name, getActivityState(),
                getMentalState(), getPhysicalState());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return (obj instanceof Human human)
                && (activityState.equals(human.activityState)
                && mentalState.equals(human.mentalState)
                && physicalState.equals(human.physicalState))
                && name.equals(human.name);
    }

    @Override
    public String toString(){
        return String.format("Human(name=%s, activityState=%s, mentalState=%s, physicalState=%s)", name, activityState, mentalState, physicalState);
    }
}
