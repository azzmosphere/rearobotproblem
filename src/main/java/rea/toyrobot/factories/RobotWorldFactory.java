package rea.toyrobot.factories;

import rea.toyrobot.config.mapper.RobotRectangleWorldConfig;
import rea.toyrobot.worlds.RobotRectangleWorld;
import rea.toyrobot.worlds.WorldInterface;

public class RobotWorldFactory extends ObjectFactory<WorldInterface, RobotRectangleWorld>  implements ObjectFactoryInterface<WorldInterface, RobotRectangleWorldConfig>   {
    public RobotWorldFactory() {
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
