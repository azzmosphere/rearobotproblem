package rea.toyrobot.worlds;

import java.util.Map;

public class RobotRectangleWorld implements WorldInterface {
    @Override
    public boolean canMoveTo(int x, int y) {
        return false;
    }

    @Override
    public void setObject(int x, int y) {

    }

    @Override
    public void removeObject(int x, int y) {

    }

    @Override
    public void initialise(Map defaults) {

    }
}
