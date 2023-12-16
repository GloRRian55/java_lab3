package places.types;

public enum PlaceType {
    TOWN ("towm"),
    GARDEN ("garden"),
    SMALL_BUILDING("small building");

    private final String placeType;
    PlaceType(String placeType){
        this.placeType = placeType;
    }

    @Override
    public String toString(){
        return placeType;
    }
}
