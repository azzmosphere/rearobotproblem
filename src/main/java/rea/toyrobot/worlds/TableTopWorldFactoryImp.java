package rea.toyrobot.worlds;

import rea.toyrobot.config.mapper.RobotRectangleWorldConfig;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.factories.ObjectFactory;

import java.util.Map;
import java.util.HashMap;

public class TableTopWorldFactoryImp extends ObjectFactory<World, TableTopWorld> implements TableTopWorldFactory {
    private RobotRectangleWorldConfig mapper;

    public TableTopWorldFactoryImp() {
        super(TableTopWorld.class);
    }

    @Override
    protected TableTopWorld init(TableTopWorld object) throws RobotInitialisationException {
        Map defaults = new HashMap();
        defaults.put("width", mapper.getWidth());
        defaults.put("length", mapper.getLength());
        object.initialise(defaults);

        return object;
    }

    @Override
    public void setObjectMapper(RobotRectangleWorldConfig mapper) {
        this.mapper = mapper;
    }
}
