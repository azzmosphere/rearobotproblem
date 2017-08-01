package rea.toyrobot.config.mapper;

import javax.xml.bind.annotation.XmlElement;

public class RobotCompassConfig {
    private String initpos;

    @XmlElement
    public void setInitialpos(String initialpos) {
        this.initpos = initialpos;
    }

    public String getInitialpos() {
        return initpos;
    }
}
