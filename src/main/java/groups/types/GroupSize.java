package groups.types;

public enum GroupSize {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    final String size;
    GroupSize(String size) {
        this.size = size;
    }

    @Override
    public String toString(){
        return size;
    }
}
