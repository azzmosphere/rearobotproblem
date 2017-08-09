TOY ROBOT APPLICATION
=====================

The Toy Robot application is designed to be as flexible as possible.  With 
that in mind aside from the initialiser and core all concrete classes are 
produced by either the initialiser or a factory that complies to a interface 
and is dynamically loaded.  The only representation is the interface, the concrete
implementation is derived from the robottoyrc.xsd file.

The idea is that the program can be extended minimal code changes.

to run the program the following command is used:

To execute the program the following command can be issued:

``
java -jar rearobotproblem-1.0.jar  -s path/to/schema/robottoy.xsd -c /path/to/config/config.xsd
``

On UNIX systems a executable stub can be generated using the command:

```
gradle build
gradle createExe
```

This feature should be considered highly experimental as it relies on the JAVA_HOME variable being set.

However if it works then the following is possible:

``
rearobotproblem -s path/to/schema/robottoy.xsd -c /path/to/config/config.xsd
 ``  
 
The default configuration and XSD can be found in:

XSD: [ROOT_DIR]/generated/robottoy.xsd
XML: [ROOT_DIR]/config/robottoyrc.xml

To build the project the following command can be used:

``gradle build``

**PROGRAM** **USAGE**

By default two clients are implemented,

1. Command Line Interface Client

2. File Client

To use the file interface set the environmental variable _ROBOTCMDS_

```
export ROBOTCMD=`pwd`/src/test/data/sample.1.txt
java -jar ./build/libs/rearobotproblem-1.0.jar -s ./src/generated/robottoy.xsd -c ./src/config/robottoyrc.xml
```

**IMPORTANT** **CONCEPTS**

Some important concepts to the program are that:

* A RobotClient (any class that conforms to the RobotClient interface) acts as a interface for the end user. Each client
is executed in its own thread.  All clients interact with the same _RobotService_. By default there is one client which 
is the command line client. Clients can be added by modifying the configuration file.

* A action is a command that is issued via the _RobotClient_ to the _RobotService_, actions can communicate back to 
the client via the _RobotResponder_

Actions are broken into three groups, these are:

** __LocalActions__ : Actions that only affect the perspective of the PhysicalObject and have no effect on the World.
** __GlobalActions__ : Actions that change the worlds perspective of the PhysicalObject
** __WorldActions__ : Actions which change the world, such as adding a new Physical object.

Actions can be added dynamically by configuration.

__CAVEATS__

As per requirements, there are no other obstacles on the table when the program starts, however two PLACE commands within
the same session will result in two robots being created which is considered a obstacle.

As per specifications there is currently no way to 
* quit the application, 
* remove a robot from the table
* display the table top.


In terms of the design the following considerations have been made:

1. All instances that belong to a object are created via a factory;
2. Services are created by a initialiser;



config.mapppers
===============

Configuration file bindings used to initialise classes.

exceptions
==========

Any exception that be thrown by the applicaiton

factories
=========

Originally it was a package for all factories. However changing the scope of 
this to hold. 

The package now holds abstractions that all factories can use, these are:

 __ObjectFactoryInterface__ 
 
 This is used by objects that require specific configuration provided by 
 config.mappings, outside of the factory container itself.
 
 The interface requires two methods to be defined:
 
 _create()_
 
 this returns the concrete object.
 
 _setObjectMapper()_
 
 This is called by the initialise object and sets the mapper for the 
 interface that is getting created.
 
 __ObjectFactory__ 

*TODO: Change to AbstractObjectFactory

This is a abstract class that complies with ObjectFactoryInterface that provides
a generic way of creating the concrete object.

perspectives
============

A perspective is a physical objects (such as a robot) view of the world. It has 
three attributes which affect it.  These are: 

___cardinal___ ___direction___ (compass) which describe from the robots point of view 
which way it is facing.

___x___ ___coordinate___ the poistion on the X plane of a planner graph that the 
robot will be located within the world.

___y___ ___coordinate___ the position on the Y plan of a planner graph that the 
robot will be located within the world.

__Perspective__

The perspective is the interface that is created by the _PerspectiveFactory_ it provides
the following methods

_getXPos()_ the current X position

_getYPos()_ the current Y position

_setXPos()_ set the current X position

_setYPos()_ set the current Y position

_getDirection()_ returns the current direction that the robot is facing.

_setDirection()_ sets the direction that the robot will be facing.

__RobotTableTopPerspective__

A concrete implementation for Perspective for a robot on a TableTop world.

__PerspectiveFactory__

interface for factory object that creates perspective concrete objects.

__RobotPerspectiveFactory__

Creates a RobotTableTopPerspective instance.

world
=====

A world represents all the points that a physical object such as a robot can occupy.
It is in charge of enforcing any physical rules that the robot must abide by. Such
as physical boundries of the world.

__World__

Interface for worlds that physical objects such as robots can occupy. The
following methods are defined:

___canMoveTo(PhysicalObject, x, y)___ Returns true if the physical object can move to
position X:Y.

___setObject(PhysicalObject, x, y)___ places physical object at position X:Y

___removeObject(PysicalObject)___ removes the pysical object from the world.

___relocateObject(PhysicalObject, x, y)___ relocates physical object from its
current location to position X:Y

___initialise(WorldConfig)___ called by factory to initialise the world.

__WorldFactory__

Interface for world factory.  The world factory accepts WorldConfig which 
defines the following attributes 

width: Entire how many horizontal units are available in the world.
height: How many vertical units are available in the world.


__TableTopWorldWorldFactory__

concrete implementation of the world factory

actions.world
==============

World actions affect the world and are responsible for the creation and 
deconstruction of the physical objects.  They accept the World concrete 
object as a argument.

__WorldAction__ (interface)

__WorldActionFactory__ (factory class for world actions)

Produces a array of WorldActions for the executor.

__WorldActionPlace__

__actions.physicalobjects.GlobalActionFactory__ 

produces a list of global actions for executor.

A global action action affects the world and the robot.

actions are:

___ActionMove___

__actions.physicalobjects.LocalAction__

produces a list of actions that only affect the robot's perspective and not the 
world.

___ActionLeft___

___ActionRight___

___ActionReport___

actions.pysicalobject.perspective
=================================

Actions that are controlled from within the robot, these actions are divided
into two parts.  Physical object factories have PerspectiveFactory as a 
argument, this is because a perspective belongs only to a physical object
and not to the rest of the world.

__actions.physicalobjects.localised__

These actions affect the robots perspective but have no affect on the world.
Localised actions receive the physical object as a argument.

LocalActionLeft

LocalActionRight

LocalActionReport

__action.physicalobjects.global__

Global actions change a physical objects perspective as well as the world.
The physical object and the world are arguments to these actions.

GlobalActionMove

physicalobjects
===============

Physical objects represent a member of the world that represents one unit.

__PhysicalObject__ (interface)

__PhysicalObjectFactory__ (factory interface for physical objects)

__ToyRobotFactory__ (concrete factory implementation of the robot factory)

__ToyRobot__ (robot implementation of the physical object)

interface
=========

The interface provides a means for input to be provided to the 
executor.

__interface.request__

__interface.response__

executor
=======

reads requests, and iterates through actions.  The action perform the 
business logic and there output is provided to the responder.

initialiser
==========

reads XML configuration and produces the factories

