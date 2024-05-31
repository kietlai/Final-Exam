//Implements the following
// [] Create an edit for single person using scanner to make sure that this module works without much extra effort.
// []
// []
// []
// []

//Methods:


//Imports:
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class AssignmentGroup {
  private String assignmentName;
  private double fullGrade;
  private HashMap<String, Assignment> studentWork;

  // * Constructors
  /**
   * Constructor for the Assignment Group
   * @param title The name of the assignment
   * @param fg The full points that can be given without extra credit (i.e 100 percent)
   * @param names The ArrayList of the names of the students within your class
   */
  public AssignmentGroup(String title, int fg, ArrayList<String> names) {
    assignmentName = title;
    fullGrade = (double) fg;
    studentWork = new HashMap<String, Assignment>();
    this.addStudentList(names);
  }

  /**
   * Constructor for the assignment group without any names added or assignments added.
   * @param title
   * @param fg
   */
  public AssignmentGroup(String title, int fg) {
    assignmentName = title;
    fullGrade = (double) fg;
    studentWork = new HashMap<String, Assignment>();
  }

  /**
   * Required to be called in order to add the students into the class. 
   * @param studentNames The arraylist of names in order to loop through and create assignment instances for every one of the students.
   */
  public void addStudentList(ArrayList<String> studentNames) {
    for (String name: studentNames) {
      this.studentWork.put(name, new Assignment(this.assignmentName, this.fullGrade));
    }
  }

  // * Getters

  /**
   * Returns the hashmap of all the students
   * @return Hashmap of all of teh students
   */
  public HashMap<String, Assignment> getStudentWork() {
    return studentWork;
  }

  /**
   * Assignment name
   * @return gets the assignment name
   */
  public String getAssignmentName() {
    return this.assignmentName;
  }

  /**
   * Gets full grade
   * @return Full grade
   */
  public double getFullGrade() {
    return this.fullGrade;
  }

  // ! Special
  /**
   * 
   * @return returns the average of the assignment
   */
  public double getAverage() {
    double total = 0.0;
    double count = 0.0;

    for(String name: this.studentWork.keySet()) {
      if (!this.studentWork.get(name).findPercentage().equals("N/A")){
        count++; 
        total+=Double.parseDouble(this.studentWork.get(name).findPercentage().substring(0,this.studentWork.get(name).findPercentage().indexOf("%")));
      }
    }
    //Checks if no one has grades
    if (total == 0.0){
      return 0.0;
    }

    return total/count;
  }


  // * Setters

  /**
   * Changes the title for the assignment group itself and all the elements within it.
   * @param nTitle The new title for the assignment.
   */
  public void newTitle(String nTitle) {
    this.assignmentName = nTitle;
    // Loops through and fixes all the assignment names.
    for (String name: studentWork.keySet()) {
      this.studentWork.get(name).setTitle(nTitle);
      
    }
  }

  /**
   * Changes full grade for itself and all the elements that are within it
   * @param newFullGrade the new full grade
   */
  public void changeFullGrade(int newFullGrade) {
    this.fullGrade = (double) newFullGrade;
    for (String name: studentWork.keySet()) {
      this.studentWork.get(name).setFullGrade(this.fullGrade);
    }
  }

  /**
   * Used to add new students into the assignment will be used within the 
   * @param studentName This info will be supplied by the last element in the studentnames arraylist.
   */
  public void addStudent(String studentName) {
    this.studentWork.put(studentName, new Assignment(this.assignmentName, this.fullGrade));
    System.out.println("Do you want to edit "+ studentName + "'s grade? (Y/N)");
    Scanner sc = new Scanner(System.in);
    String res = sc.nextLine();

    if (res.equalsIgnoreCase("Y")) {
      this.editGrade(studentName);

    }

  }

  /**
   * Sets the earned grade for each student
   * @param name name of the student to be edited
   */
  public void editGrade(String name) {
    Scanner scan = new Scanner(System.in);
    System.out.println("What will the earned grade be?");

    // Scans for the new graded assignment
    String studentGrade = scan.nextLine();

    this.gradeChangeSelector(name, studentGrade);

    //Prints the updated score
    System.out.print(name + " updated score is: " + this.studentWork.get(name).getEarnedGrade() + " out of " +this.studentWork.get(name).getFullGrade());

    System.out.println("|  "+this.studentWork.get(name).getLetterGrade()+" "+this.studentWork.get(name).findPercentage()+"\n");

  }

  /**
   * Used to edit all the grades in the group.
   */
  public void editGradeEarnedPoints() {
    Scanner scan = new Scanner(System.in);

    //Loops through the list of assignments and then asks for each grade
    for (String name: this.studentWork.keySet()) {
      double curGrade = this.studentWork.get(name).getEarnedGrade();
      String wa = this.studentWork.get(name).toString();

      String fixedCurGrade = Double.toString(curGrade);
      
      if (curGrade<0) {
        fixedCurGrade = "N/A";
      }
      
      System.out.println("You can do both certain grade earned or percentage? Denote percentage with the percentage following the number (i.e 96%)\n");
      

      //lets the teacher now what there current grade is
      System.out.println("Edit the grade of " + name + " | Current earned grade is " + fixedCurGrade + " out of " + fullGrade);
      System.out.println("What will the earned grade be?");

      // Scans for the new graded assignment
      String studentGrade = scan.nextLine();

      this.gradeChangeSelector(name, studentGrade);

      //Prints the updated score
      System.out.print(name + " updated score is: " + this.studentWork.get(name).getEarnedGrade() + " out of " +this.studentWork.get(name).getFullGrade());

      System.out.println("  |  "+this.studentWork.get(name).getLetterGrade()+" "+this.studentWork.get(name).findPercentage()+"\n");

    }
    
  }
  
  // !EXPERIMENTAL
  //Second trial
  

   /**
    * <h1>Grade Change Selector</h1>
    * Changes the grades based on the type of input
    * @param name The name of the student
    * @param input The input from scanner or later maybe even a UI
    */
   public void gradeChangeSelector(String name, String input) {
    //tool pack to easily get work done
    double grade = this.studentWork.get(name).getFullGrade();

     if(!input.contains("%")) {
       this.studentWork.get(name).setEarnedGrade(Double.parseDouble(input));

     } else {

       double calc = (Double.parseDouble(input.replace("%", "")))*0.01;
       this.studentWork.get(name).setEarnedGrade(calc*grade);
     }

      //Changes the grade to whatever grade percentage it is.

   }

  /**
   * The to string method for the assignment groupings
   * @return It returns the formatted version of all of the assignments.
   */
  public String toString() {

    String ans = "Assignment Name: "+this.assignmentName + "\nFull Score: " + fullGrade + "\nThe Average Grade in the class was: " + this.getAverage() + "%\n";

    for (String name: this.studentWork.keySet()) {
      ans += "|Name: " + name + "\t|Grade: " + this.studentWork.get(name).getLetterGrade() + this.studentWork.get(name).findPercentage() + "\t|\n";

    }
    return ans;
  }


  
}