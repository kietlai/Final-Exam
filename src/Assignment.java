// Implement the following:

// - Title
// - Earned Grade
// - Full Grade
// - Letter Grade

// Methods:
// [X] Getters and Setters
// [X] Letter grade generator
// [X] create a toString
// [] Add colors to the toString
// [X] Make sure that the data update for the letter grades. 

/**
 * <h1>Assignment Class</h1>
 * Used to create assignments for each class and student.
 * @author Quoc-Kiet Lai
 * @since 2024-05-06
 */

public class Assignment {
  private String title;
  private double earnedGrade;
  private double fullGrade;
  private String letterGrade;
  
  // For putting in everything all at once

  /**
   * Constructor for the Assignment Class including everything
   * @param t Title of the assignment
   * @param fG The max amount of points that can be achieved/100% (Without consideration of extra-credit). 
   * @param eG The score that the person earned on the assignment.
   */
  public Assignment(String t, double fG, double eG) {

    this.title = t;

    this.earnedGrade = eG;
    this.fullGrade = fG;

    this.letterGrade = giveLetterGrade(fG, eG);

  }

  /**
   * Constructor for the Assignment Class, missing earned grade 
   * @param t Title of the assignment
   * @param fG  The max amount of points that can be achieved/100% (Without consideration of extra-credit).
   */

  // Missing given grade
  public Assignment(String t, double fG) {
    this.title = t;

    this.earnedGrade = Integer.MIN_VALUE;
    this.fullGrade = fG;

    this.letterGrade = "P";

  }

  /**
   * Used to get the letter grade from the percentage earned.
   * @param earnedGrade Takes in the score that the person earned on the assignment.
   * @param fullGrade Takes in the max amount of points that can be achieved/100% (Without consideration of extra-credit).
   * @return A letter that represents the grade that they recieved. scale from A-E, P is a placeholder/error
   */

  public String giveLetterGrade(double earnedGrade, double fullGrade) {
    double calc = earnedGrade/fullGrade;

    //used to check what percentage each are
    if (calc >= 0.9) {
      return "A";

    } else if (calc >= 0.8) {
      return "B";

    } else if (calc >= 0.7) {
      return "C";

    } else if (calc >= 0.6) {
      return "D";

    } else if (calc >= 0.0) {
      return "E";

    } else {
      // P is a place holder or error
      return "P";
    }
  }

  // Getters are in the following
  /**
   *
   * @return Returns the Assignments' full grade
   */
  public double getFullGrade() {
    return this.fullGrade;
  }

  /**
   * 
   * @return Returns the Assignments' earned grade
   */
  public double getEarnedGrade() {
    return this.earnedGrade;
  }

  /**
   * 
   * @return Returns the Assignments' title
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * 
   * @return Returns the Assignments' lettergrade
   */
  public String getLetterGrade() {
    return this.letterGrade;
  }

  //Setters
  /**
   * Sets the full grade
   * @param nFullGrade New full grade
   */
  public void setFullGrade(double nFullGrade) {
    this.fullGrade=nFullGrade;
    // Makes sure that the letter grade is updated.
    this.letterGrade=giveLetterGrade(this.earnedGrade, this.fullGrade);
  }

  /**
   * Sets the earned grade
   * @param nEarnedGrade New earned grade
   */
  public void setEarnedGrade(double nEarnedGrade) {
    this.earnedGrade=nEarnedGrade;
    // Makes sure that the letter grade is updated.
    this.letterGrade=giveLetterGrade(this.earnedGrade, this.fullGrade);
  }

  /**
   * Sets a new title
   * @param nTitle New title
   */
  public void setTitle(String nTitle) {
    this.title=nTitle;
  }

  /**
   * Sets a new letter grade
   * @param nLetterGrade New letter grade
   */
  public void setLetter(String nLetterGrade) {
    this.title=nLetterGrade;
  }



  /**
   * Finds the percentage and returns it as a String that is truncated
   * @return Returns the percantage in a string formate
   */
  public String findPercentage() {
    if (this.earnedGrade<0) {
      return "N/A";
    } else {
      //Does the math to convert the double percentage into a string.
      String unfilteredPercentage = String.valueOf((this.earnedGrade/this.fullGrade)*10);
      //Truncates it back fron all of the decimals
      return unfilteredPercentage.substring(0, unfilteredPercentage.indexOf("."+1));
    }
    
  }
  
  public String toString() {
    return "|\tAssignment Name: " + this.title + "\t|\t Grade: " + this.letterGrade +this.findPercentage()+"\t|";
  }

  public String colored_toString() {
    //for letter use an if statement to get this to work.
    // It may not work on all screens so might not be worth it.
   final String RESET = "\033[0m";  // Text Reset
    
    // Regular Colors
    final String RED = "\033[0;31m";     // RED
    final String BLACK = "\033[0;30m";   // BLACK
    final String GREEN = "\033[0;32m";   // GREEN
    final String YELLOW = "\033[0;33m";  // YELLOW
    final String BLUE = "\033[0;34m";    // BLUE
    final String PURPLE = "\033[0;35m";  // PURPLE
    final String CYAN = "\033[0;36m";    // CYAN
    final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    final String BLACK_BOLD = "\033[1;30m";  // BLACK
    final String RED_BOLD = "\033[1;31m";    // RED
    final String GREEN_BOLD = "\033[1;32m";  // GREEN
    final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    final String BLUE_BOLD = "\033[1;34m";   // BLUE
    final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    final String CYAN_BOLD = "\033[1;36m";   // CYAN
    final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    final String RED_UNDERLINED = "\033[4;31m";    // RED
    final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    final String RED_BACKGROUND = "\033[41m";    // RED
    final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    final String RED_BRIGHT = "\033[0;91m";    // RED
    final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    return "";
  }
}
