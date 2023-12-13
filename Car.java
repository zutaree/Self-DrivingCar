/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 21 "model.ump"
// line 160 "model.ump"
public class Car extends Vehicle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Car Attributes
  private String currentLocation;
  private String speed;
  private String destination;

  //Car State Machines
  public enum States { IDLE, NAVIGATIONINPROGRESS, PARKING, EMERGENCYSTOP }
  public enum StatesNAVIGATIONINPROGRESS { Null, NAVIGATING, DYNAMICROUTEADJUSTMENT, H }
  private States states;
  private StatesNAVIGATIONINPROGRESS statesNAVIGATIONINPROGRESS;
  private StatesNAVIGATIONINPROGRESS statesNAVIGATIONINPROGRESSH;

  //Car Do Activity Threads
  Thread doActivity0StatesNAVIGATIONINPROGRESSThread = null;
  Thread doActivity1StatesNAVIGATIONINPROGRESSThread = null;

  //Car Associations
  private SensorSuite sensorSuite;
  private User user;
  private List<Route> routes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Car(String aMake, String aModel, String aCurrentLocation, String aSpeed, String aDestination, SensorSuite aSensorSuite, User aUser)
  {
    super(aMake, aModel);
    currentLocation = aCurrentLocation;
    speed = aSpeed;
    destination = aDestination;
    if (aSensorSuite == null || aSensorSuite.getCar() != null)
    {
      throw new RuntimeException("Unable to create Car due to aSensorSuite. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    sensorSuite = aSensorSuite;
    boolean didAddUser = setUser(aUser);
    if (!didAddUser)
    {
      throw new RuntimeException("Unable to create car due to user. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    routes = new ArrayList<Route>();
    setStatesNAVIGATIONINPROGRESS(StatesNAVIGATIONINPROGRESS.Null);
    statesNAVIGATIONINPROGRESSH = StatesNAVIGATIONINPROGRESS.NAVIGATING;
    setStates(States.IDLE);
  }

  public Car(String aMake, String aModel, String aCurrentLocation, String aSpeed, String aDestination, String aSensorTypeForSensorSuite, String aDetectionRangeForSensorSuite, CollisionAvoidanceSystem aCollisionAvoidanceSystemForSensorSuite, ParkingAssistSystem aParkingAssistSystemForSensorSuite, ProximitySensor aProximitySensorForSensorSuite, Camera aCameraForSensorSuite, Radar aRadarForSensorSuite, User aUser)
  {
    super(aMake, aModel);
    currentLocation = aCurrentLocation;
    speed = aSpeed;
    destination = aDestination;
    sensorSuite = new SensorSuite(aSensorTypeForSensorSuite, aDetectionRangeForSensorSuite, aCollisionAvoidanceSystemForSensorSuite, aParkingAssistSystemForSensorSuite, aProximitySensorForSensorSuite, aCameraForSensorSuite, aRadarForSensorSuite, this);
    boolean didAddUser = setUser(aUser);
    if (!didAddUser)
    {
      throw new RuntimeException("Unable to create car due to user. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    routes = new ArrayList<Route>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCurrentLocation(String aCurrentLocation)
  {
    boolean wasSet = false;
    currentLocation = aCurrentLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setSpeed(String aSpeed)
  {
    boolean wasSet = false;
    speed = aSpeed;
    wasSet = true;
    return wasSet;
  }

  public boolean setDestination(String aDestination)
  {
    boolean wasSet = false;
    destination = aDestination;
    wasSet = true;
    return wasSet;
  }

  public String getCurrentLocation()
  {
    return currentLocation;
  }

  public String getSpeed()
  {
    return speed;
  }

  public String getDestination()
  {
    return destination;
  }

  public String getStatesFullName()
  {
    String answer = states.toString();
    if (statesNAVIGATIONINPROGRESS != StatesNAVIGATIONINPROGRESS.Null) { answer += "." + statesNAVIGATIONINPROGRESS.toString(); }
    return answer;
  }

  public States getStates()
  {
    return states;
  }

  public StatesNAVIGATIONINPROGRESS getStatesNAVIGATIONINPROGRESS()
  {
    return statesNAVIGATIONINPROGRESS;
  }

  public boolean userInputDestination()
  {
    boolean wasEventProcessed = false;
    
    States aStates = states;
    switch (aStates)
    {
      case IDLE:
        setStatesNAVIGATIONINPROGRESS(statesNAVIGATIONINPROGRESSH);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean dangerDetected()
  {
    boolean wasEventProcessed = false;
    
    States aStates = states;
    switch (aStates)
    {
      case NAVIGATIONINPROGRESS:
        exitStates();
        setStates(States.EMERGENCYSTOP);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean destinationReached()
  {
    boolean wasEventProcessed = false;
    
    States aStates = states;
    switch (aStates)
    {
      case NAVIGATIONINPROGRESS:
        exitStates();
        setStates(States.PARKING);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean parkingComplete()
  {
    boolean wasEventProcessed = false;
    
    States aStates = states;
    switch (aStates)
    {
      case PARKING:
        exitStates();
        setStates(States.IDLE);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean emergencyResolved()
  {
    boolean wasEventProcessed = false;
    
    States aStates = states;
    switch (aStates)
    {
      case EMERGENCYSTOP:
        exitStates();
        setStates(States.NAVIGATIONINPROGRESS);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean obstacleDetected()
  {
    boolean wasEventProcessed = false;
    
    StatesNAVIGATIONINPROGRESS aStatesNAVIGATIONINPROGRESS = statesNAVIGATIONINPROGRESS;
    if (statesNAVIGATIONINPROGRESS != StatesNAVIGATIONINPROGRESS.Null){statesNAVIGATIONINPROGRESSH = statesNAVIGATIONINPROGRESS;}
    switch (aStatesNAVIGATIONINPROGRESS)
    {
      case NAVIGATING:
        exitStatesNAVIGATIONINPROGRESS();
        setStatesNAVIGATIONINPROGRESS(StatesNAVIGATIONINPROGRESS.DYNAMICROUTEADJUSTMENT);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean alternativeRouteDetected()
  {
    boolean wasEventProcessed = false;
    
    StatesNAVIGATIONINPROGRESS aStatesNAVIGATIONINPROGRESS = statesNAVIGATIONINPROGRESS;
    if (statesNAVIGATIONINPROGRESS != StatesNAVIGATIONINPROGRESS.Null){statesNAVIGATIONINPROGRESSH = statesNAVIGATIONINPROGRESS;}
    switch (aStatesNAVIGATIONINPROGRESS)
    {
      case DYNAMICROUTEADJUSTMENT:
        exitStatesNAVIGATIONINPROGRESS();
        setStatesNAVIGATIONINPROGRESS(StatesNAVIGATIONINPROGRESS.NAVIGATING);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitStates()
  {
    switch(states)
    {
      case NAVIGATIONINPROGRESS:
        exitStatesNAVIGATIONINPROGRESS();
        if (doActivity0StatesNAVIGATIONINPROGRESSThread != null) { doActivity0StatesNAVIGATIONINPROGRESSThread.interrupt(); }
        if (doActivity1StatesNAVIGATIONINPROGRESSThread != null) { doActivity1StatesNAVIGATIONINPROGRESSThread.interrupt(); }
        break;
      case PARKING:
        // line 55 "model.ump"
        deactivateParkingAssistSystem();
        break;
      case EMERGENCYSTOP:
        // line 62 "model.ump"
        deactivateEmergencyMode();
        break;
    }
  }

  private void setStates(States aStates)
  {
    states = aStates;

    // entry actions and do activities
    switch(states)
    {
      case IDLE:
        // line 35 "model.ump"
        display('idle');
        break;
      case NAVIGATIONINPROGRESS:
        doActivity0StatesNAVIGATIONINPROGRESSThread = new DoActivityThread(this,"doActivity0StatesNAVIGATIONINPROGRESS");
        doActivity1StatesNAVIGATIONINPROGRESSThread = new DoActivityThread(this,"doActivity1StatesNAVIGATIONINPROGRESS");
        if (statesNAVIGATIONINPROGRESS == StatesNAVIGATIONINPROGRESS.Null) { setStatesNAVIGATIONINPROGRESS(StatesNAVIGATIONINPROGRESS.NAVIGATING); }
        break;
      case PARKING:
        // line 54 "model.ump"
        activateParkingAssistSystem();
        break;
      case EMERGENCYSTOP:
        // line 60 "model.ump"
        activateEmergencyBrakingSystem();
        // line 61 "model.ump"
        alertTheUser();
        break;
    }
  }

  private void exitStatesNAVIGATIONINPROGRESS()
  {
    switch(statesNAVIGATIONINPROGRESS)
    {
      case NAVIGATING:
        setStatesNAVIGATIONINPROGRESS(StatesNAVIGATIONINPROGRESS.Null);
        break;
      case DYNAMICROUTEADJUSTMENT:
        setStatesNAVIGATIONINPROGRESS(StatesNAVIGATIONINPROGRESS.Null);
        break;
      case H:
        setStatesNAVIGATIONINPROGRESS(StatesNAVIGATIONINPROGRESS.Null);
        break;
    }
  }

  private void setStatesNAVIGATIONINPROGRESS(StatesNAVIGATIONINPROGRESS aStatesNAVIGATIONINPROGRESS)
  {
    statesNAVIGATIONINPROGRESS = aStatesNAVIGATIONINPROGRESS;
    if (states != States.NAVIGATIONINPROGRESS && aStatesNAVIGATIONINPROGRESS != StatesNAVIGATIONINPROGRESS.Null) { setStates(States.NAVIGATIONINPROGRESS); }

    // entry actions and do activities
    switch(statesNAVIGATIONINPROGRESS)
    {
      case DYNAMICROUTEADJUSTMENT:
        // line 47 "model.ump"
        display('rerouting');
        break;
    }
  }
  /* Code from template association_GetOne */
  public SensorSuite getSensorSuite()
  {
    return sensorSuite;
  }
  /* Code from template association_GetOne */
  public User getUser()
  {
    return user;
  }
  /* Code from template association_GetMany */
  public Route getRoute(int index)
  {
    Route aRoute = routes.get(index);
    return aRoute;
  }

  public List<Route> getRoutes()
  {
    List<Route> newRoutes = Collections.unmodifiableList(routes);
    return newRoutes;
  }

  public int numberOfRoutes()
  {
    int number = routes.size();
    return number;
  }

  public boolean hasRoutes()
  {
    boolean has = routes.size() > 0;
    return has;
  }

  public int indexOfRoute(Route aRoute)
  {
    int index = routes.indexOf(aRoute);
    return index;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setUser(User aUser)
  {
    boolean wasSet = false;
    //Must provide user to car
    if (aUser == null)
    {
      return wasSet;
    }

    if (user != null && user.numberOfCars() <= User.minimumNumberOfCars())
    {
      return wasSet;
    }

    User existingUser = user;
    user = aUser;
    if (existingUser != null && !existingUser.equals(aUser))
    {
      boolean didRemove = existingUser.removeCar(this);
      if (!didRemove)
      {
        user = existingUser;
        return wasSet;
      }
    }
    user.addCar(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRoutes()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Route addRoute(String aStartLocation, String aEndLocation, String aTrafficConditions, GPS_System aCarGPS)
  {
    return new Route(aStartLocation, aEndLocation, aTrafficConditions, this, aCarGPS);
  }

  public boolean addRoute(Route aRoute)
  {
    boolean wasAdded = false;
    if (routes.contains(aRoute)) { return false; }
    Car existingPersonalCar = aRoute.getPersonalCar();
    boolean isNewPersonalCar = existingPersonalCar != null && !this.equals(existingPersonalCar);
    if (isNewPersonalCar)
    {
      aRoute.setPersonalCar(this);
    }
    else
    {
      routes.add(aRoute);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRoute(Route aRoute)
  {
    boolean wasRemoved = false;
    //Unable to remove aRoute, as it must always have a personalCar
    if (!this.equals(aRoute.getPersonalCar()))
    {
      routes.remove(aRoute);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRouteAt(Route aRoute, int index)
  {  
    boolean wasAdded = false;
    if(addRoute(aRoute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoutes()) { index = numberOfRoutes() - 1; }
      routes.remove(aRoute);
      routes.add(index, aRoute);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRouteAt(Route aRoute, int index)
  {
    boolean wasAdded = false;
    if(routes.contains(aRoute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoutes()) { index = numberOfRoutes() - 1; }
      routes.remove(aRoute);
      routes.add(index, aRoute);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRouteAt(aRoute, index);
    }
    return wasAdded;
  }

  private void doActivity0StatesNAVIGATIONINPROGRESS()
  {
    try
    {
      // line 49 "model.ump"
      monitorEnvironment();
      Thread.sleep(1);
    }
    catch (InterruptedException e)
    {

    }
  }

  private void doActivity1StatesNAVIGATIONINPROGRESS()
  {
    try
    {
      // line 50 "model.ump"
      updateNavData();
      Thread.sleep(1);
    }
    catch (InterruptedException e)
    {

    }
  }

  private static class DoActivityThread extends Thread
  {
    Car controller;
    String doActivityMethodName;
    
    public DoActivityThread(Car aController,String aDoActivityMethodName)
    {
      controller = aController;
      doActivityMethodName = aDoActivityMethodName;
      start();
    }
    
    public void run()
    {
      if ("doActivity0StatesNAVIGATIONINPROGRESS".equals(doActivityMethodName))
      {
        controller.doActivity0StatesNAVIGATIONINPROGRESS();
      }
        else if ("doActivity1StatesNAVIGATIONINPROGRESS".equals(doActivityMethodName))
      {
        controller.doActivity1StatesNAVIGATIONINPROGRESS();
      }
    }
  }

  public void delete()
  {
    SensorSuite existingSensorSuite = sensorSuite;
    sensorSuite = null;
    if (existingSensorSuite != null)
    {
      existingSensorSuite.delete();
    }
    User placeholderUser = user;
    this.user = null;
    if(placeholderUser != null)
    {
      placeholderUser.removeCar(this);
    }
    for(int i=routes.size(); i > 0; i--)
    {
      Route aRoute = routes.get(i - 1);
      aRoute.delete();
    }
    super.delete();
  }

  // line 28 "model.ump"
  public void navigateTo(String destination){
    
  }

  // line 29 "model.ump"
  public void accelerate(Integer speed){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "currentLocation" + ":" + getCurrentLocation()+ "," +
            "speed" + ":" + getSpeed()+ "," +
            "destination" + ":" + getDestination()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "sensorSuite = "+(getSensorSuite()!=null?Integer.toHexString(System.identityHashCode(getSensorSuite())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "user = "+(getUser()!=null?Integer.toHexString(System.identityHashCode(getUser())):"null");
  }
}