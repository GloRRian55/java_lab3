package groups;

import groups.types.GroupSize;
import interfaces.InsideMovable;
import places.Place;

public class Procession extends Group implements InsideMovable {
    public Procession() {
        super("procession", GroupSize.SMALL);
    }

    @Override
    public void moveInsidePlace(Place place, String route) {
        System.out.printf("The %s is moving inside %s to %s%n i", name, place, route);
    }
}
