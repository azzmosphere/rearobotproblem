TOY ROBOT APPLICATION
=====================

The Toy Robot application is designed to be as flexible as possible.  With 
that in mind aside from the initialiser all concrete classes are produced by
a factory that complies to a interface and is dynamically loaded.

The idea is that the program can be extended with no code changes, new code
can be added, or minimal code changes.

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

__WorldActionFactory__ (factory interface)

__WorldActionPlaceFactory__ (factory class for Place action)

__WorldActionPlace__

actions.pysicalobject.perspective
=================================

Actions that are controlled from within the robot, these actions are divided
into two parts.  Physical object factories have PerspectiveFactory as a 
argument, this is because a perspective belongs only to a physical object
and not to the rest of the world.

__actions.robot.perspective.localised__

These actions affect the robots perspective but have no affect on the world.
Localised actions receive the physical object as a argument.

LocalActionLeft

LocalActionRight

LocalActionReport

__action.robot.perspective.global__

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

