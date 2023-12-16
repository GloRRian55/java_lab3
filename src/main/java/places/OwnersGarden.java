package places;

import places.types.PlaceType;

public class OwnersGarden extends Place {
    public OwnersGarden() {
        super("owner's garden", PlaceType.GARDEN);
    }

    public class Shed extends Place {
        public Shed() {
            super("shed in the owner's garden", PlaceType.SMALL_BUILDING);
        }
    }
}
