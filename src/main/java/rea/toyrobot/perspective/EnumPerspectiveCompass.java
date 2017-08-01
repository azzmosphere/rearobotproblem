package rea.toyrobot.perspective;

public enum  EnumPerspectiveCompass implements PerspectiveCompass {
    NORTH("EAST", "WEST", "NORTH"),
    EAST("SOUTH", "NORTH", "EAST"),
    SOUTH("WEST", "EAST", "SOUTH"),
    WEST("NORTH", "SOUTH", "WEST")
    ;

    private String id, next, previous;
    EnumPerspectiveCompass(String next, String previous, String id) {
        this.id = id;
        this.next = next;
        this.previous = previous;
    }

    @Override
    public PerspectiveCompass rotateClockwise() {
        return getCardinalDirection(next);
    }

    @Override
    public PerspectiveCompass rotateAntiClockwise() {
        return getCardinalDirection(previous);
    }

    @Override
    public PerspectiveCompass getCardinalDirection(String cardinalDirection) {
        PerspectiveCompass perspectiveCompass = null;
        for (EnumPerspectiveCompass perspective : EnumPerspectiveCompass.values()) {
            if (perspective.id.equals(cardinalDirection)) {
                perspectiveCompass = perspective;
            }
        }
        return perspectiveCompass;
    }
}
