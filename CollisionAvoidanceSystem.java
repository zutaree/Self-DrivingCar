/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 94 "model.ump"
// line 183 "model.ump"
public class CollisionAvoidanceSystem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CollisionAvoidanceSystem Attributes
  private boolean isActive;
  private String avoidanceStrategy;
  private float collisionThreshold;

  //CollisionAvoidanceSystem Associations
  private SensorSuite sensorSuite;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CollisionAvoidanceSystem(boolean aIsActive, String aAvoidanceStrategy, float aCollisionThreshold, SensorSuite aSensorSuite)
  {
    isActive = aIsActive;
    avoidanceStrategy = aAvoidanceStrategy;
    collisionThreshold = aCollisionThreshold;
    if (aSensorSuite == null || aSensorSuite.getCollisionAvoidanceSystem() != null)
    {
      throw new RuntimeException("Unable to create CollisionAvoidanceSystem due to aSensorSuite. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    sensorSuite = aSensorSuite;
  }

  public CollisionAvoidanceSystem(boolean aIsActive, String aAvoidanceStrategy, float aCollisionThreshold, String aSensorTypeForSensorSuite, String aDetectionRangeForSensorSuite, ParkingAssistSystem aParkingAssistSystemForSensorSuite, ProximitySensor aProximitySensorForSensorSuite, Camera aCameraForSensorSuite, Radar aRadarForSensorSuite, Car aCarForSensorSuite)
  {
    isActive = aIsActive;
    avoidanceStrategy = aAvoidanceStrategy;
    collisionThreshold = aCollisionThreshold;
    sensorSuite = new SensorSuite(aSensorTypeForSensorSuite, aDetectionRangeForSensorSuite, this, aParkingAssistSystemForSensorSuite, aProximitySensorForSensorSuite, aCameraForSensorSuite, aRadarForSensorSuite, aCarForSensorSuite);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsActive(boolean aIsActive)
  {
    boolean wasSet = false;
    isActive = aIsActive;
    wasSet = true;
    return wasSet;
  }

  public boolean setAvoidanceStrategy(String aAvoidanceStrategy)
  {
    boolean wasSet = false;
    avoidanceStrategy = aAvoidanceStrategy;
    wasSet = true;
    return wasSet;
  }

  public boolean setCollisionThreshold(float aCollisionThreshold)
  {
    boolean wasSet = false;
    collisionThreshold = aCollisionThreshold;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsActive()
  {
    return isActive;
  }

  public String getAvoidanceStrategy()
  {
    return avoidanceStrategy;
  }

  public float getCollisionThreshold()
  {
    return collisionThreshold;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsActive()
  {
    return isActive;
  }
  /* Code from template association_GetOne */
  public SensorSuite getSensorSuite()
  {
    return sensorSuite;
  }

  public void delete()
  {
    SensorSuite existingSensorSuite = sensorSuite;
    sensorSuite = null;
    if (existingSensorSuite != null)
    {
      existingSensorSuite.delete();
    }
  }

  // line 99 "model.ump"
  public void avoidCollision(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "isActive" + ":" + getIsActive()+ "," +
            "avoidanceStrategy" + ":" + getAvoidanceStrategy()+ "," +
            "collisionThreshold" + ":" + getCollisionThreshold()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "sensorSuite = "+(getSensorSuite()!=null?Integer.toHexString(System.identityHashCode(getSensorSuite())):"null");
  }
}