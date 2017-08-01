package rea.toyrobot.factories;

import rea.toyrobot.config.mapper.RobotRectangleWorldConfig;
import rea.toyrobot.exceptions.RobotInitialisationException;
import rea.toyrobot.worlds.RobotRectangleWorld;
import rea.toyrobot.worlds.WorldInterface;
import java.util.Map;
import java.util.HashMap;

public class RobotRectangleWorldFactory extends ObjectFactory<WorldInterface, RobotRectangleWorld>  implements ObjectFactoryInterface<WorldInterface, RobotRectangleWorldConfig>   {
    private RobotRectangleWorldConfig mapper;

    public RobotRectangleWorldFactory() {
        super(RobotRectangleWorld.class);
    }

    @Override
    protected RobotRectangleWorld init(RobotRectangleWorld object) throws RobotInitialisationException {
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
