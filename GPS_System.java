/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 77 "model.ump"
// line 173 "model.ump"
public class GPS_System
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GPS_System Attributes
  private String currentLocation;
  private String speed;
  private String destination;

  //GPS_System Associations
  private List<Route> routes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GPS_System(String aCurrentLocation, String aSpeed, String aDestination)
  {
    currentLocation = aCurrentLocation;
    speed = aSpeed;
    destination = aDestination;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRoutes()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Route addRoute(String aStartLocation, String aEndLocation, String aTrafficConditions, Car aPersonalCar)
  {
    return new Route(aStartLocation, aEndLocation, aTrafficConditions, aPersonalCar, this);
  }

  public boolean addRoute(Route aRoute)
  {
    boolean wasAdded = false;
    if (routes.contains(aRoute)) { return false; }
    GPS_System existingCarGPS = aRoute.getCarGPS();
    boolean isNewCarGPS = existingCarGPS != null && !this.equals(existingCarGPS);
    if (isNewCarGPS)
    {
      aRoute.setCarGPS(this);
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
    //Unable to remove aRoute, as it must always have a carGPS
    if (!this.equals(aRoute.getCarGPS()))
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

  public void delete()
  {
    for(int i=routes.size(); i > 0; i--)
    {
      Route aRoute = routes.get(i - 1);
      aRoute.delete();
    }
  }

  // line 82 "model.ump"
  public void calculateRoute(){
    
  }

  // line 83 "model.ump"
  public void getETA(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "currentLocation" + ":" + getCurrentLocation()+ "," +
            "speed" + ":" + getSpeed()+ "," +
            "destination" + ":" + getDestination()+ "]";
  }
}