package rea.toyrobot.perspective;

/**
 * implementation of perspective compass that uses a enum to determine
 * the cardinal points of the compass.
 */

public enum  EnumPerspectiveCompass implements PerspectiveCompass {
    NORTH("EAST", "WEST", "NORTH"),
    EAST("SOUTH", "NORTH", "EAST"),
    SOUTH("WEST", "EAST", "SOUTH"),
    WEST("NORTH", "SOUTH", "WEST");

    private String id, next, previous;
    EnumPerspectiveCompass(String next, String previous, String id) {
        this.id = id;
        this.next = next;
        this.previous = previous;
    }

    @Override
    public PerspectiveCompass rotateClockwise() {
        return findCardinalDirection(next);
    }

    @Override
    public PerspectiveCompass rotateAntiClockwise() {
        return findCardinalDirection(previous);
    }

    @Override
    public PerspectiveCompass findCardinalDirection(String cardinalDirection) {
        PerspectiveCompass perspectiveCompass = null;
        for (EnumPerspectiveCompass perspective : EnumPerspectiveCompass.values()) {
            if (perspective.id.equalsIgnoreCase(cardinalDirection)) {
                perspectiveCompass = perspective;
                break;
            }
        }
        return perspectiveCompass;
    }

    @Override
    public String getCardinalDirection() {
        return id;
    }
}
