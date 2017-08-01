package rea.toyrobot.perspective;

public class RobotWorldView implements RobotWorldPerspective {
    private int x, y;
    PerspectiveCompass compass;

    @Override
    public int getXPos() {
        return x;
    }

    @Override
    public void setXPos(int x) {
        this.x = x;
    }

    @Override
    public int getYpos() {
        return y;
    }

    @Override
    public void setYPos(int y) {
        this.y = y;
    }

    @Override
    public PerspectiveCompass getCompass() {
        return compass;
    }

    @Override
    public void setCompass(PerspectiveCompass compass) {
        this.compass = compass;
    }
}
