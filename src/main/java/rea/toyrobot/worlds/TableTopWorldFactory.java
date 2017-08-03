package rea.toyrobot.worlds;

import rea.toyrobot.factories.ObjectFactoryInterface;
import rea.toyrobot.config.mapper.RobotRectangleWorldConfig;

/**
 * interface to allow generic worlds to be configured.  When worlds are added
 * they need to implement this interface before they can be activated in
 * configuration
 */

public interface TableTopWorldFactory extends ObjectFactoryInterface<World, RobotRectangleWorldConfig> {
}