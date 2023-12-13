/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 115 "model.ump"
// line 198 "model.ump"
public class ProximitySensor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProximitySensor Attributes
  private String proximitysensorType;
  private String proximitydetectionRange;

  //ProximitySensor Associations
  private SensorSuite sensorSuite;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProximitySensor(String aProximitysensorType, String aProximitydetectionRange, SensorSuite aSensorSuite)
  {
    proximitysensorType = aProximitysensorType;
    proximitydetectionRange = aProximitydetectionRange;
    if (aSensorSuite == null || aSensorSuite.getProximitySensor() != null)
    {
      throw new RuntimeException("Unable to create ProximitySensor due to aSensorSuite. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    sensorSuite = aSensorSuite;
  }

  public ProximitySensor(String aProximitysensorType, String aProximitydetectionRange, String aSensorTypeForSensorSuite, String aDetectionRangeForSensorSuite, CollisionAvoidanceSystem aCollisionAvoidanceSystemForSensorSuite, ParkingAssistSystem aParkingAssistSystemForSensorSuite, Camera aCameraForSensorSuite, Radar aRadarForSensorSuite, Car aCarForSensorSuite)
  {
    proximitysensorType = aProximitysensorType;
    proximitydetectionRange = aProximitydetectionRange;
    sensorSuite = new SensorSuite(aSensorTypeForSensorSuite, aDetectionRangeForSensorSuite, aCollisionAvoidanceSystemForSensorSuite, aParkingAssistSystemForSensorSuite, this, aCameraForSensorSuite, aRadarForSensorSuite, aCarForSensorSuite);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setProximitysensorType(String aProximitysensorType)
  {
    boolean wasSet = false;
    proximitysensorType = aProximitysensorType;
    wasSet = true;
    return wasSet;
  }

  public boolean setProximitydetectionRange(String aProximitydetectionRange)
  {
    boolean wasSet = false;
    proximitydetectionRange = aProximitydetectionRange;
    wasSet = true;
    return wasSet;
  }

  public String getProximitysensorType()
  {
    return proximitysensorType;
  }

  public String getProximitydetectionRange()
  {
    return proximitydetectionRange;
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

  // line 118 "model.ump"
  public void initiateProximityDetection(){
    
  }

  // line 119 "model.ump"
  public void adjustProximityDetectionRange(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "proximitysensorType" + ":" + getProximitysensorType()+ "," +
            "proximitydetectionRange" + ":" + getProximitydetectionRange()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "sensorSuite = "+(getSensorSuite()!=null?Integer.toHexString(System.identityHashCode(getSensorSuite())):"null");
  }
}