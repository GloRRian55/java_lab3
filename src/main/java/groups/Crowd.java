package groups;

import groups.types.GroupSize;
import interfaces.InsideMovable;
import places.Place;

public class Crowd extends Group implements InsideMovable {
    public Crowd() {
        super("crowd", GroupSize.LARGE);
    }

    @Override
    public void moveInsidePlace(Place place, String route) {
        System.out.printf("The %s is moving inside %s to %s%n", name, place, route);
    }
}
