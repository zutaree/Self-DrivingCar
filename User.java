/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 11 "model.ump"
// line 154 "model.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String username;
  private String preferences;
  private String favoriteDestination;

  //User Associations
  private List<Car> cars;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aUsername, String aPreferences, String aFavoriteDestination)
  {
    username = aUsername;
    preferences = aPreferences;
    favoriteDestination = aFavoriteDestination;
    cars = new ArrayList<Car>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    username = aUsername;
    wasSet = true;
    return wasSet;
  }

  public boolean setPreferences(String aPreferences)
  {
    boolean wasSet = false;
    preferences = aPreferences;
    wasSet = true;
    return wasSet;
  }

  public boolean setFavoriteDestination(String aFavoriteDestination)
  {
    boolean wasSet = false;
    favoriteDestination = aFavoriteDestination;
    wasSet = true;
    return wasSet;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPreferences()
  {
    return preferences;
  }

  public String getFavoriteDestination()
  {
    return favoriteDestination;
  }
  /* Code from template association_GetMany */
  public Car getCar(int index)
  {
    Car aCar = cars.get(index);
    return aCar;
  }

  public List<Car> getCars()
  {
    List<Car> newCars = Collections.unmodifiableList(cars);
    return newCars;
  }

  public int numberOfCars()
  {
    int number = cars.size();
    return number;
  }

  public boolean hasCars()
  {
    boolean has = cars.size() > 0;
    return has;
  }

  public int indexOfCar(Car aCar)
  {
    int index = cars.indexOf(aCar);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfCarsValid()
  {
    boolean isValid = numberOfCars() >= minimumNumberOfCars();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCars()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Car addCar(String aMake, String aModel, String aCurrentLocation, String aSpeed, String aDestination, SensorSuite aSensorSuite)
  {
    Car aNewCar = new Car(aMake, aModel, aCurrentLocation, aSpeed, aDestination, aSensorSuite, this);
    return aNewCar;
  }

  public boolean addCar(Car aCar)
  {
    boolean wasAdded = false;
    if (cars.contains(aCar)) { return false; }
    User existingUser = aCar.getUser();
    boolean isNewUser = existingUser != null && !this.equals(existingUser);

    if (isNewUser && existingUser.numberOfCars() <= minimumNumberOfCars())
    {
      return wasAdded;
    }
    if (isNewUser)
    {
      aCar.setUser(this);
    }
    else
    {
      cars.add(aCar);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCar(Car aCar)
  {
    boolean wasRemoved = false;
    //Unable to remove aCar, as it must always have a user
    if (this.equals(aCar.getUser()))
    {
      return wasRemoved;
    }

    //user already at minimum (1)
    if (numberOfCars() <= minimumNumberOfCars())
    {
      return wasRemoved;
    }

    cars.remove(aCar);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCarAt(Car aCar, int index)
  {  
    boolean wasAdded = false;
    if(addCar(aCar))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCars()) { index = numberOfCars() - 1; }
      cars.remove(aCar);
      cars.add(index, aCar);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCarAt(Car aCar, int index)
  {
    boolean wasAdded = false;
    if(cars.contains(aCar))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCars()) { index = numberOfCars() - 1; }
      cars.remove(aCar);
      cars.add(index, aCar);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCarAt(aCar, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=cars.size(); i > 0; i--)
    {
      Car aCar = cars.get(i - 1);
      aCar.delete();
    }
  }

  // line 17 "model.ump"
  public void setPreferences(){
    
  }

  // line 18 "model.ump"
  public void receiveNotification(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "," +
            "preferences" + ":" + getPreferences()+ "," +
            "favoriteDestination" + ":" + getFavoriteDestination()+ "]";
  }
}