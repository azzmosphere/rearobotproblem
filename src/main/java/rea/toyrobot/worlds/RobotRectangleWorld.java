package rea.toyrobot.worlds;

import rea.toyrobot.exceptions.RobotDoesNotExistException;
import rea.toyrobot.exceptions.RobotDuplicatedLocationException;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.exceptions.RobotOutOfBoundsException;

import java.util.Map;

public class RobotRectangleWorld implements WorldInterface {
    @Override
    public boolean canMoveTo(int x, int y) {
        return false;
    }

    @Override
    public void setObject(int x, int y) throws RobotDuplicatedLocationException {

    }

    @Override
    public void removeObject(int x, int y) {

    }

    @Override
    public void relocateObject(int x, int y, int x2, int y2) throws RobotDuplicatedLocationException, RobotOutOfBoundsException, RobotDoesNotExistException {

    }

    @Override
    public void initialise(Map defaults) throws RobotInitialisationException {
    }
}
