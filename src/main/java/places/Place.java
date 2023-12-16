package places;

import exception.ObjectAlreadyInPlaceException;
import exception.ObjectNotInThisPlaceException;
import groups.Group;
import humans.Human;
import places.types.PlaceType;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Place {
    protected Place(String name, PlaceType type) {
        this.name = name;
        this.type = type;
    }
    public final PlaceType type;
    public final String name;

    protected ArrayList<Human> humans = new ArrayList<>();
    protected ArrayList<Group> groups = new ArrayList<>();

    public void placeObject(Human person){
        if (humans.contains(person)){
            throw new ObjectAlreadyInPlaceException(
                    String.format("'Human' %s object is already contains in 'Place' %s object%n", person, this)
            );
        }
        humans.add(person);
        System.out.printf("%s is now in the %s%n", person, this);
    }
    public void placeObject(Group group){
        if (groups.contains(group)){
            throw new ObjectAlreadyInPlaceException(
                    String.format("'Group' %s object is already contains in 'Place' %s object%n", group, this)
            );
        }
        groups.add(group);
        System.out.printf("%s is now in the %s%n", group, this);
    }

    public void replaceObject(Human person){
        if (!humans.contains(person)){
            throw new ObjectNotInThisPlaceException(
                    String.format("'Human' %s object cannot be deleted because it is not contained in the %s object%n", person, this)
            );
        }
        humans.remove(person);
        System.out.printf("%s left the %s%n", person, this);
    }
    public void replaceObject(Group group){
        if (!groups.contains(group)){
            throw new ObjectNotInThisPlaceException(
                    String.format("'Group' %s object cannot be deleted because it is not contained in the %s 'Place' object", group, this)
            );
        }
        groups.remove(group);
        System.out.printf("%s left the %s%n", group, this);
    }

    public void placeAll(Human[] humans){
        for (Human human : humans) placeObject(human);
    }
    public void placeAll(Group[] groups){
        for (Group group : groups) placeObject(group);
    }

//    public Human[] getAllHumans(){
//        return humans.toArray(new Human[0]);
//    }
//    public Group[] getAllGroups(){
//        return groups.toArray(new Group[0]);
//    }


    public boolean contains(Human person){
        return humans.contains(person);
    }
    public boolean contains(Group group){
        return groups.contains(group);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, type, humans, groups);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        return (obj instanceof Place place)
                && name.equals(place.name)
                && type.equals(place.type)
                && humans.equals(place.humans)
                && groups.equals(place.groups);
    }

    @Override
    public String toString(){
        return String.format("Place(name=%s, type=%s, %d humans, %d groups)", name, type, humans.size(), groups.size());
    }
}

