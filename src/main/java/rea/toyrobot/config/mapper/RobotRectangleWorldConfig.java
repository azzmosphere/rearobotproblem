package rea.toyrobot.config.mapper;

/**
 * Configuration for robot rectangle world configuration.
 */

import javax.xml.bind.annotation.XmlElement;

public class RobotRectangleWorldConfig {
    private int length, width;

    @XmlElement
    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    @XmlElement
    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
