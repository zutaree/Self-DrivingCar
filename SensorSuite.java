/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 102 "model.ump"
// line 188 "model.ump"
public class SensorSuite
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SensorSuite Attributes
  private String sensorType;
  private String detectionRange;

  //SensorSuite Associations
  private CollisionAvoidanceSystem collisionAvoidanceSystem;
  private ParkingAssistSystem parkingAssistSystem;
  private ProximitySensor proximitySensor;
  private Camera camera;
  private Radar radar;
  private Car car;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SensorSuite(String aSensorType, String aDetectionRange, CollisionAvoidanceSystem aCollisionAvoidanceSystem, ParkingAssistSystem aParkingAssistSystem, ProximitySensor aProximitySensor, Camera aCamera, Radar aRadar, Car aCar)
  {
    sensorType = aSensorType;
    detectionRange = aDetectionRange;
    if (aCollisionAvoidanceSystem == null || aCollisionAvoidanceSystem.getSensorSuite() != null)
    {
      throw new RuntimeException("Unable to create SensorSuite due to aCollisionAvoidanceSystem. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    collisionAvoidanceSystem = aCollisionAvoidanceSystem;
    if (aParkingAssistSystem == null || aParkingAssistSystem.getSensorSuite() != null)
    {
      throw new RuntimeException("Unable to create SensorSuite due to aParkingAssistSystem. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    parkingAssistSystem = aParkingAssistSystem;
    if (aProximitySensor == null || aProximitySensor.getSensorSuite() != null)
    {
      throw new RuntimeException("Unable to create SensorSuite due to aProximitySensor. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    proximitySensor = aProximitySensor;
    if (aCamera == null || aCamera.getSensorSuite() != null)
    {
      throw new RuntimeException("Unable to create SensorSuite due to aCamera. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    camera = aCamera;
    if (aRadar == null || aRadar.getSensorSuite() != null)
    {
      throw new RuntimeException("Unable to create SensorSuite due to aRadar. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    radar = aRadar;
    if (aCar == null || aCar.getSensorSuite() != null)
    {
      throw new RuntimeException("Unable to create SensorSuite due to aCar. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    car = aCar;
  }

  public SensorSuite(String aSensorType, String aDetectionRange, boolean aIsActiveForCollisionAvoidanceSystem, String aAvoidanceStrategyForCollisionAvoidanceSystem, float aCollisionThresholdForCollisionAvoidanceSystem, String aParkingSpaceForParkingAssistSystem, String aProximitysensorTypeForProximitySensor, String aProximitydetectionRangeForProximitySensor, String aCameraSensorTypeForCamera, String aResolutionForCamera, String aRadarSensorTypeForRadar, String aFrequencyForRadar, String aMakeForCar, String aModelForCar, String aCurrentLocationForCar, String aSpeedForCar, String aDestinationForCar, User aUserForCar)
  {
    sensorType = aSensorType;
    detectionRange = aDetectionRange;
    collisionAvoidanceSystem = new CollisionAvoidanceSystem(aIsActiveForCollisionAvoidanceSystem, aAvoidanceStrategyForCollisionAvoidanceSystem, aCollisionThresholdForCollisionAvoidanceSystem, this);
    parkingAssistSystem = new ParkingAssistSystem(aParkingSpaceForParkingAssistSystem, this);
    proximitySensor = new ProximitySensor(aProximitysensorTypeForProximitySensor, aProximitydetectionRangeForProximitySensor, this);
    camera = new Camera(aCameraSensorTypeForCamera, aResolutionForCamera, this);
    radar = new Radar(aRadarSensorTypeForRadar, aFrequencyForRadar, this);
    car = new Car(aMakeForCar, aModelForCar, aCurrentLocationForCar, aSpeedForCar, aDestinationForCar, this, aUserForCar);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSensorType(String aSensorType)
  {
    boolean wasSet = false;
    sensorType = aSensorType;
    wasSet = true;
    return wasSet;
  }

  public boolean setDetectionRange(String aDetectionRange)
  {
    boolean wasSet = false;
    detectionRange = aDetectionRange;
    wasSet = true;
    return wasSet;
  }

  public String getSensorType()
  {
    return sensorType;
  }

  public String getDetectionRange()
  {
    return detectionRange;
  }
  /* Code from template association_GetOne */
  public CollisionAvoidanceSystem getCollisionAvoidanceSystem()
  {
    return collisionAvoidanceSystem;
  }
  /* Code from template association_GetOne */
  public ParkingAssistSystem getParkingAssistSystem()
  {
    return parkingAssistSystem;
  }
  /* Code from template association_GetOne */
  public ProximitySensor getProximitySensor()
  {
    return proximitySensor;
  }
  /* Code from template association_GetOne */
  public Camera getCamera()
  {
    return camera;
  }
  /* Code from template association_GetOne */
  public Radar getRadar()
  {
    return radar;
  }
  /* Code from template association_GetOne */
  public Car getCar()
  {
    return car;
  }

  public void delete()
  {
    CollisionAvoidanceSystem existingCollisionAvoidanceSystem = collisionAvoidanceSystem;
    collisionAvoidanceSystem = null;
    if (existingCollisionAvoidanceSystem != null)
    {
      existingCollisionAvoidanceSystem.delete();
    }
    ParkingAssistSystem existingParkingAssistSystem = parkingAssistSystem;
    parkingAssistSystem = null;
    if (existingParkingAssistSystem != null)
    {
      existingParkingAssistSystem.delete();
    }
    ProximitySensor existingProximitySensor = proximitySensor;
    proximitySensor = null;
    if (existingProximitySensor != null)
    {
      existingProximitySensor.delete();
    }
    Camera existingCamera = camera;
    camera = null;
    if (existingCamera != null)
    {
      existingCamera.delete();
    }
    Radar existingRadar = radar;
    radar = null;
    if (existingRadar != null)
    {
      existingRadar.delete();
    }
    Car existingCar = car;
    car = null;
    if (existingCar != null)
    {
      existingCar.delete();
    }
  }

  // line 111 "model.ump"
  public void detectObstacles(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "sensorType" + ":" + getSensorType()+ "," +
            "detectionRange" + ":" + getDetectionRange()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "collisionAvoidanceSystem = "+(getCollisionAvoidanceSystem()!=null?Integer.toHexString(System.identityHashCode(getCollisionAvoidanceSystem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "parkingAssistSystem = "+(getParkingAssistSystem()!=null?Integer.toHexString(System.identityHashCode(getParkingAssistSystem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "proximitySensor = "+(getProximitySensor()!=null?Integer.toHexString(System.identityHashCode(getProximitySensor())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "camera = "+(getCamera()!=null?Integer.toHexString(System.identityHashCode(getCamera())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "radar = "+(getRadar()!=null?Integer.toHexString(System.identityHashCode(getRadar())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "car = "+(getCar()!=null?Integer.toHexString(System.identityHashCode(getCar())):"null");
  }
}