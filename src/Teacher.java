import java.util.ArrayList;

public class Teacher {
  private String name;
  private String aboutYou;
  private ArrayList<Classroom> yourClasses;

  public Teacher (String name, String aboutYou) {
    this.name = name;
    this.aboutYou = aboutYou;
    this.yourClasses = new ArrayList<Classroom>();

  }


  // ! Getters
  public String getName() {
    return name;
  }

  public String getAboutYou() {
    return aboutYou;
  }

  public ArrayList<Classroom> getYourClasses() {
    return yourClasses;
  }

  // ! Setters

  public void setAboutYou(String aboutYou) {
    this.aboutYou = aboutYou;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * Adds a class to your classes
   * @param newClass the new class to be added.
   */
  public void addYourClass(Classroom newClass) {
    yourClasses.add(newClass);
  }



}
