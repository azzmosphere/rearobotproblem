package rea.toyrobot.client;

import rea.toyrobot.executor.RobotService;

/**
 * A client provides a means to communicate with the RobotService.
 * It should send a command to the service in the form of:
 *  COMMAND ARG1,...ARGn
 *
 *  for instance
 *
 *  PLACE 1,2,EAST
 *
 *  If there is no arguments to correspond with a command then just the
 *  command will suffice.  White is used to break up commands and grouped
 *  options for instance:
 *
 *  PLACE 1,2,EAST ROBOT
 *
 *  would be acceptable command. Commands are bound in configuration.
 *
 *  Each client is expected to run within there won thread.
 *
 *  The class must implement the method run()
 *
 *  The run method should call the execute() action on the
 *  robotService and interpret the results from the RobotResponder
 *  providing details back to the end user.
 */

public interface RobotClient extends  Runnable {

    void setRobotService(RobotService robotService);
}
