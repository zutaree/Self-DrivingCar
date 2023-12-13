/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 86 "model.ump"
// line 178 "model.ump"
public class Bike extends Vehicle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bike Attributes
  private String bikeType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bike(String aMake, String aModel, String aBikeType)
  {
    super(aMake, aModel);
    bikeType = aBikeType;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBikeType(String aBikeType)
  {
    boolean wasSet = false;
    bikeType = aBikeType;
    wasSet = true;
    return wasSet;
  }

  public String getBikeType()
  {
    return bikeType;
  }

  public void delete()
  {
    super.delete();
  }

  // line 90 "model.ump"
  public void ride(){
    
  }

  // line 91 "model.ump"
  public void accelerate(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "bikeType" + ":" + getBikeType()+ "]";
  }
}