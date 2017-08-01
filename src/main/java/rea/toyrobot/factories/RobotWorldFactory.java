package rea.toyrobot.factories;

import rea.toyrobot.worlds.WorldInterface;
import rea.toyrobot.config.mapper.RobotRectangleWorldConfig;

/**
 * interface to allow generic worlds to be configured.  When worlds are added
 * they need to implement this interface before they can be activated in
 * configuration
 */

public interface RobotWorldFactory extends ObjectFactoryInterface<WorldInterface, RobotRectangleWorldConfig> {
}