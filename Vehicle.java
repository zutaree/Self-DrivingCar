/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 2 "model.ump"
// line 149 "model.ump"
public class Vehicle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Vehicle Attributes
  private String make;
  private String model;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Vehicle(String aMake, String aModel)
  {
    make = aMake;
    model = aModel;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMake(String aMake)
  {
    boolean wasSet = false;
    make = aMake;
    wasSet = true;
    return wasSet;
  }

  public boolean setModel(String aModel)
  {
    boolean wasSet = false;
    model = aModel;
    wasSet = true;
    return wasSet;
  }

  public String getMake()
  {
    return make;
  }

  public String getModel()
  {
    return model;
  }

  public void delete()
  {}

  // line 6 "model.ump"
  public void startEngine(){
    
  }

  // line 7 "model.ump"
  public void stopEngine(){
    
  }

  // line 8 "model.ump"
  public void accelerate(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "make" + ":" + getMake()+ "," +
            "model" + ":" + getModel()+ "]";
  }
}