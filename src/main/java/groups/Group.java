package groups;

import exception.StateAlreadyRunningException;
import groups.types.GroupSize;
import groups.types.GroupState;

import java.util.Objects;

public abstract class Group {
    protected Group(String name, GroupSize size){
        this.name = name;
        this.size = size;
    }
    public final String name;
    public final GroupSize size;
    protected GroupState state = GroupState.DEFAULT;

    public GroupState getState() {
        return state;
    }

    protected void setState(GroupState state) {
        this.state = state;
        System.out.printf("%s now does %s%n", this, state);
    }

    protected void run(GroupState state, Runnable activity){
        if (state == this.state){
            throw new StateAlreadyRunningException(
                    String.format("Group state %s is already using by %s 'Group' object%n", state, this)
            );
        }

        setState(state);
        GroupState originState = this.state;
        activity.run();
        setState(originState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return (obj instanceof Group group)
                && size.equals(group.size)
                && name.equals(group.name);
    }
    @Override
    public String toString(){
        return String.format("Group(name=%s, size=%s, state=%s)", name, size, state);
    }

}
