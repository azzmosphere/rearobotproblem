package rea.toyrobot.config.mapper;

/**
 * Configuration for robot rectangle world configuration.
 */

import javax.xml.bind.annotation.XmlElement;

public class RobotRectagleWorldConfig {
    @XmlElement
    public void setWidth(int width) {}

    public int getWidth() {return 0;}

    @XmlElement
    public void setLength(int length) {}

    public int getLength() {return 0;}
}
