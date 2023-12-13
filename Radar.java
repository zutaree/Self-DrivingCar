/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 130 "model.ump"
// line 208 "model.ump"
public class Radar
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Radar Attributes
  private String radarSensorType;
  private String frequency;

  //Radar Associations
  private SensorSuite sensorSuite;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Radar(String aRadarSensorType, String aFrequency, SensorSuite aSensorSuite)
  {
    radarSensorType = aRadarSensorType;
    frequency = aFrequency;
    if (aSensorSuite == null || aSensorSuite.getRadar() != null)
    {
      throw new RuntimeException("Unable to create Radar due to aSensorSuite. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    sensorSuite = aSensorSuite;
  }

  public Radar(String aRadarSensorType, String aFrequency, String aSensorTypeForSensorSuite, String aDetectionRangeForSensorSuite, CollisionAvoidanceSystem aCollisionAvoidanceSystemForSensorSuite, ParkingAssistSystem aParkingAssistSystemForSensorSuite, ProximitySensor aProximitySensorForSensorSuite, Camera aCameraForSensorSuite, Car aCarForSensorSuite)
  {
    radarSensorType = aRadarSensorType;
    frequency = aFrequency;
    sensorSuite = new SensorSuite(aSensorTypeForSensorSuite, aDetectionRangeForSensorSuite, aCollisionAvoidanceSystemForSensorSuite, aParkingAssistSystemForSensorSuite, aProximitySensorForSensorSuite, aCameraForSensorSuite, this, aCarForSensorSuite);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRadarSensorType(String aRadarSensorType)
  {
    boolean wasSet = false;
    radarSensorType = aRadarSensorType;
    wasSet = true;
    return wasSet;
  }

  public boolean setFrequency(String aFrequency)
  {
    boolean wasSet = false;
    frequency = aFrequency;
    wasSet = true;
    return wasSet;
  }

  public String getRadarSensorType()
  {
    return radarSensorType;
  }

  public String getFrequency()
  {
    return frequency;
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

  // line 134 "model.ump"
  public void scanEnvironment(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "radarSensorType" + ":" + getRadarSensorType()+ "," +
            "frequency" + ":" + getFrequency()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "sensorSuite = "+(getSensorSuite()!=null?Integer.toHexString(System.identityHashCode(getSensorSuite())):"null");
  }
}