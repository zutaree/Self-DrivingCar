/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 139 "model.ump"
// line 213 "model.ump"
public class ParkingAssistSystem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ParkingAssistSystem Attributes
  private String parkingSpace;

  //ParkingAssistSystem Associations
  private SensorSuite sensorSuite;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ParkingAssistSystem(String aParkingSpace, SensorSuite aSensorSuite)
  {
    parkingSpace = aParkingSpace;
    if (aSensorSuite == null || aSensorSuite.getParkingAssistSystem() != null)
    {
      throw new RuntimeException("Unable to create ParkingAssistSystem due to aSensorSuite. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    sensorSuite = aSensorSuite;
  }

  public ParkingAssistSystem(String aParkingSpace, String aSensorTypeForSensorSuite, String aDetectionRangeForSensorSuite, CollisionAvoidanceSystem aCollisionAvoidanceSystemForSensorSuite, ProximitySensor aProximitySensorForSensorSuite, Camera aCameraForSensorSuite, Radar aRadarForSensorSuite, Car aCarForSensorSuite)
  {
    parkingSpace = aParkingSpace;
    sensorSuite = new SensorSuite(aSensorTypeForSensorSuite, aDetectionRangeForSensorSuite, aCollisionAvoidanceSystemForSensorSuite, this, aProximitySensorForSensorSuite, aCameraForSensorSuite, aRadarForSensorSuite, aCarForSensorSuite);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setParkingSpace(String aParkingSpace)
  {
    boolean wasSet = false;
    parkingSpace = aParkingSpace;
    wasSet = true;
    return wasSet;
  }

  public String getParkingSpace()
  {
    return parkingSpace;
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

  // line 142 "model.ump"
  public void findParkingSpace(){
    
  }

  // line 143 "model.ump"
  public void park(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "parkingSpace" + ":" + getParkingSpace()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "sensorSuite = "+(getSensorSuite()!=null?Integer.toHexString(System.identityHashCode(getSensorSuite())):"null");
  }
}