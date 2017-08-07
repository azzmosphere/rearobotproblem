package rea.toyrobot.worlds;


import rea.toyrobot.exceptions.RobotDoesNotExistException;
import rea.toyrobot.exceptions.RobotDuplicatedLocationException;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.exceptions.RobotOutOfBoundsException;

import java.util.Map;

/**
 * Implements the table top world for the robot toy. For more detailed
 * documentation of what the methods do, review the interface.
 */

public class TableTopWorld implements World {
    private int width, length;
    boolean[][] coordinates;

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        boolean rv = false;

        if (x < 0 || y < 0) {
            rv = false;
        }
        if (x < width && y < length && !coordinates[x][y]) {
            rv = true;
        }

        return rv;
    }

    @Override
    public void setObject(int x, int y) throws RobotDuplicatedLocationException, RobotOutOfBoundsException {
        try {
            if (coordinates[x][y]) {
                throw new RobotDuplicatedLocationException("a object exists in space " + x + ":" + y);
            }
        }
        catch (IndexOutOfBoundsException e) {
            throw new RobotOutOfBoundsException("coordinates given are out of world bounds");
        }
        coordinates[x][y] = true;
    }

    @Override
    public void removeObject(int x, int y) {
        coordinates[x][y] = false;
    }

    @Override
    public void relocateObject(int x, int y, int x2, int y2) throws RobotDuplicatedLocationException, RobotOutOfBoundsException, RobotDoesNotExistException {

        try {
            if (!coordinates[x][y]) {
                throw new RobotDoesNotExistException("robot does not exist at " + x + ":" + y);
            }

            if (!canMoveTo(x2, y2)) {
                if (coordinates[x2][y2]) {
                    throw new RobotDuplicatedLocationException("there is a existing object in location " + x2 + ":" + y2);
                }
            }
        }
        catch (IndexOutOfBoundsException e) {
            throw new RobotOutOfBoundsException("coordinates are out of world boundries");
        }

        removeObject(x, y);
        setObject(x2, y2);
    }


    //todo: this could be depreciated.
    @Override
    public void initialise(Map defaults) throws RobotInitialisationException {
        if (defaults.isEmpty() || !(defaults.containsKey("width") || defaults.containsKey("length"))) {
            throw new RobotInitialisationException("width and length are required values for world");
        }

        try {
            width = (int) defaults.get("width");
            length = (int) defaults.get("length");
            coordinates = new boolean[width][length];
        }
        catch (ClassCastException e) {
            throw new RobotInitialisationException("width and length must be numbers");
        }
        catch (NullPointerException e) {
            throw new RobotInitialisationException("width and length must be defined");
        }
        catch (Exception e) {
            throw new RobotInitialisationException("a unchecked exception has occurred details are " + e.getMessage());
        }
    }
}
