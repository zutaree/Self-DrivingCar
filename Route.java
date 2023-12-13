/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 67 "model.ump"
// line 166 "model.ump"
public class Route
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Route Attributes
  private String startLocation;
  private String endLocation;
  private String trafficConditions;

  //Route Associations
  private Car personalCar;
  private GPS_System carGPS;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetPersonalCar;
  private boolean canSetCarGPS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Route(String aStartLocation, String aEndLocation, String aTrafficConditions, Car aPersonalCar, GPS_System aCarGPS)
  {
    cachedHashCode = -1;
    canSetPersonalCar = true;
    canSetCarGPS = true;
    startLocation = aStartLocation;
    endLocation = aEndLocation;
    trafficConditions = aTrafficConditions;
    boolean didAddPersonalCar = setPersonalCar(aPersonalCar);
    if (!didAddPersonalCar)
    {
      throw new RuntimeException("Unable to create route due to personalCar. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddCarGPS = setCarGPS(aCarGPS);
    if (!didAddCarGPS)
    {
      throw new RuntimeException("Unable to create route due to carGPS. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartLocation(String aStartLocation)
  {
    boolean wasSet = false;
    startLocation = aStartLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndLocation(String aEndLocation)
  {
    boolean wasSet = false;
    endLocation = aEndLocation;
    wasSet = true;
    return wasSet;
  }

  public boolean setTrafficConditions(String aTrafficConditions)
  {
    boolean wasSet = false;
    trafficConditions = aTrafficConditions;
    wasSet = true;
    return wasSet;
  }

  public String getStartLocation()
  {
    return startLocation;
  }

  public String getEndLocation()
  {
    return endLocation;
  }

  public String getTrafficConditions()
  {
    return trafficConditions;
  }
  /* Code from template association_GetOne */
  public Car getPersonalCar()
  {
    return personalCar;
  }
  /* Code from template association_GetOne */
  public GPS_System getCarGPS()
  {
    return carGPS;
  }
  /* Code from template association_SetOneToManyAssociationClass */
  public boolean setPersonalCar(Car aPersonalCar)
  {
    boolean wasSet = false;
    if (!canSetPersonalCar) { return false; }
    if (aPersonalCar == null)
    {
      return wasSet;
    }

    Car existingPersonalCar = personalCar;
    personalCar = aPersonalCar;
    if (existingPersonalCar != null && !existingPersonalCar.equals(aPersonalCar))
    {
      existingPersonalCar.removeRoute(this);
    }
    if (!personalCar.addRoute(this))
    {
      personalCar = existingPersonalCar;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_SetOneToManyAssociationClass */
  public boolean setCarGPS(GPS_System aCarGPS)
  {
    boolean wasSet = false;
    if (!canSetCarGPS) { return false; }
    if (aCarGPS == null)
    {
      return wasSet;
    }

    GPS_System existingCarGPS = carGPS;
    carGPS = aCarGPS;
    if (existingCarGPS != null && !existingCarGPS.equals(aCarGPS))
    {
      existingCarGPS.removeRoute(this);
    }
    if (!carGPS.addRoute(this))
    {
      carGPS = existingCarGPS;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Route compareTo = (Route)obj;
  
    if (getPersonalCar() == null && compareTo.getPersonalCar() != null)
    {
      return false;
    }
    else if (getPersonalCar() != null && !getPersonalCar().equals(compareTo.getPersonalCar()))
    {
      return false;
    }

    if (getCarGPS() == null && compareTo.getCarGPS() != null)
    {
      return false;
    }
    else if (getCarGPS() != null && !getCarGPS().equals(compareTo.getCarGPS()))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (getPersonalCar() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getPersonalCar().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (getCarGPS() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getCarGPS().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetPersonalCar = false;
    canSetCarGPS = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Car placeholderPersonalCar = personalCar;
    this.personalCar = null;
    if(placeholderPersonalCar != null)
    {
      placeholderPersonalCar.removeRoute(this);
    }
    GPS_System placeholderCarGPS = carGPS;
    this.carGPS = null;
    if(placeholderCarGPS != null)
    {
      placeholderCarGPS.removeRoute(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "startLocation" + ":" + getStartLocation()+ "," +
            "endLocation" + ":" + getEndLocation()+ "," +
            "trafficConditions" + ":" + getTrafficConditions()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "personalCar = "+(getPersonalCar()!=null?Integer.toHexString(System.identityHashCode(getPersonalCar())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "carGPS = "+(getCarGPS()!=null?Integer.toHexString(System.identityHashCode(getCarGPS())):"null");
  }
}