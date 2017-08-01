package rea.toyrobot.factories;

import rea.toyrobot.config.mapper.RobotRectangleWorldConfig;
import rea.toyrobot.worlds.RobotRectangleWorld;
import rea.toyrobot.worlds.WorldInterface;

public class RobotRectangleWorldFactory extends ObjectFactory<WorldInterface, RobotRectangleWorld>  implements ObjectFactoryInterface<WorldInterface, RobotRectangleWorldConfig>   {
    public RobotRectangleWorldFactory() {
        super(RobotRectangleWorld.class);
    }

    @Override
    protected RobotRectangleWorld init(RobotRectangleWorld object) {
        return null;
    }

    @Override
    public void setObjectMapper(RobotRectangleWorldConfig mapper) {

    }
}
