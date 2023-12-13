/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 122 "model.ump"
// line 203 "model.ump"
public class Camera
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Camera Attributes
  private String cameraSensorType;
  private String resolution;

  //Camera Associations
  private SensorSuite sensorSuite;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Camera(String aCameraSensorType, String aResolution, SensorSuite aSensorSuite)
  {
    cameraSensorType = aCameraSensorType;
    resolution = aResolution;
    if (aSensorSuite == null || aSensorSuite.getCamera() != null)
    {
      throw new RuntimeException("Unable to create Camera due to aSensorSuite. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    sensorSuite = aSensorSuite;
  }

  public Camera(String aCameraSensorType, String aResolution, String aSensorTypeForSensorSuite, String aDetectionRangeForSensorSuite, CollisionAvoidanceSystem aCollisionAvoidanceSystemForSensorSuite, ParkingAssistSystem aParkingAssistSystemForSensorSuite, ProximitySensor aProximitySensorForSensorSuite, Radar aRadarForSensorSuite, Car aCarForSensorSuite)
  {
    cameraSensorType = aCameraSensorType;
    resolution = aResolution;
    sensorSuite = new SensorSuite(aSensorTypeForSensorSuite, aDetectionRangeForSensorSuite, aCollisionAvoidanceSystemForSensorSuite, aParkingAssistSystemForSensorSuite, aProximitySensorForSensorSuite, this, aRadarForSensorSuite, aCarForSensorSuite);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCameraSensorType(String aCameraSensorType)
  {
    boolean wasSet = false;
    cameraSensorType = aCameraSensorType;
    wasSet = true;
    return wasSet;
  }

  public boolean setResolution(String aResolution)
  {
    boolean wasSet = false;
    resolution = aResolution;
    wasSet = true;
    return wasSet;
  }

  public String getCameraSensorType()
  {
    return cameraSensorType;
  }

  public String getResolution()
  {
    return resolution;
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

  // line 125 "model.ump"
  public void captureImage(){
    
  }

  // line 126 "model.ump"
  public void analyzeImage(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "cameraSensorType" + ":" + getCameraSensorType()+ "," +
            "resolution" + ":" + getResolution()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "sensorSuite = "+(getSensorSuite()!=null?Integer.toHexString(System.identityHashCode(getSensorSuite())):"null");
  }
}