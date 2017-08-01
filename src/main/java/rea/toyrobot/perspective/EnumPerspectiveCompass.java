package rea.toyrobot.perspective;

public enum  EnumPerspectiveCompass implements PerspectiveCompass {
    NORTH,
    EAST,
    SOUTH,
    WEST
    ;

    @Override
    public PerspectiveCompass rotateClockwise() {
        return null;
    }

    @Override
    public PerspectiveCompass rotateAntiClockwise() {
        return null;
    }

    @Override
    public PerspectiveCompass getCardinalDirection(String cardinalDirection) {
        return null;
    }
}
