//Implements the following:

// - Student Grade Average
// - Students
// - Teacher
// - Assignments/Tests, use a or 3d/2d array maybe a new object class?

// Methods:
// [] toString
// [] classAverageGrade
// [] newAssignment

// Imports
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>Class for school Class</h1>
 * Used to create each class per student
 * @author Quoc-Kiet Lai
 * @since 2024-05-8
 */

public class Class {
  private String teacher;
  private String title;
  private String desc;
  private ArrayList<String> names;
  private ArrayList<AssignmentGroup> assignments;

  /**
   * <h2>Constructor for the "Class" class</h2>
   * @param titleName Title of the Class
   * @param teacherName name of the teacher
   * @param d Description of the class
   * @param studentNames The list of students within your class put in a string list.
   */
  public Class(String titleName, String teacherName, String d, String[] studentNames) {
    this.title = titleName;
    this.teacher = teacherName;
    this.desc = d;

    this.names = new ArrayList<String>(); 
    this.assignments = new ArrayList<AssignmentGroup>();
    //Looping to add in the names
    for (String name: studentNames) {
      names.add(name);
    }
  }


  // ! Getters
  public String getTitle() {
    return this.title;
  }

  public String getDesc() {
    return this.desc;
  }

  public String getTeacher() {
    return this.teacher;
  }

  public ArrayList<String> getNames() {
    return this.names;
  }

  public ArrayList<AssignmentGroup> getAssignments() {
    return this.assignments;
  }

  public AssignmentGroup getAssignment() {
    int i = 1;

    for (AssignmentGroup assignment: assignments) {
      System.out.println("ID: " + i + " \t Assignment name: " + assignment.getAssignmentName());
      i++;
    }

    System.out.println("Please type in either the ID or the Assignment Name");

    return this.getAssignmentHelper();

  }

  public AssignmentGroup getAssignmentHelper() {
    Scanner scan = new Scanner(System.in);


    AssignmentGroup fallBack = assignments.get(0);

    String searchTerm = scan.nextLine();

    
    try {
      int searchToID = Integer.parseInt(searchTerm);
      AssignmentGroup ans = assignments.get(searchToID-1);
      return ans;

    } catch (NumberFormatException e) {

      for (AssignmentGroup assignment: assignments) {
        if(assignment.getAssignmentName().toLowerCase().equals(searchTerm.toLowerCase())) {
          System.out.println(assignment.getAssignmentName());
          return assignment;
        }
      }
      System.out.println("INVALID NAME: Please retype in either the ID or the Assignment Name");
      this.getAssignmentHelper();

    } catch (IndexOutOfBoundsException e) {
      System.out.println("INVALID ID: Please retype in either the ID or the Assignment Name");
      this.getAssignmentHelper();

    }  
    
    return fallBack;    
  }
  // ! Setters

  /**
   * Changes the description of the Class
   * @param newDesc the new description
   */
  public void changeDescription(String newDesc) {
    this.desc = newDesc;
  }

  /**
   * Change the title
   * @param newTitle the new title
   */
  public void changeTitle(String newTitle) {
    this.title = newTitle;
  }

  /**
   * Changes the description
   * @param newTeacher The new teachers name
   */
  public void changeTeacher(String newTeacher) {
    this.teacher = newTeacher;
  }

  /**
   * Adds a new student
   * @param studentName the name of the student.
   */
  public void addStudent(String studentName) {
    this.names.add(studentName);

    for (AssignmentGroup assignment: assignments) {
      assignment.addStudent(studentName);
    }
  }

  /**
   * <h2>Adds an assignment to the class. </h2>
   * @param title The title of the new assignment
   * @param fullGrade The full grade aka 100% earned
   */
  public void newAssignment(String title, int fullGrade) {
    this.assignments.add(new AssignmentGroup(title, fullGrade));
    this.assignments.get(this.assignments.size()-1).addStudentList(names);
  }

  public String showAllAssignments() {
    String assigns = "";

    for (AssignmentGroup assignment: assignments) {
      assigns += "| Assignment Name: " + assignment.getAssignmentName() + " | Full Grade: " + assignment.getFullGrade() + " | Average Grade: " + assignment.getAverage() + " |\n";
    }

    return assigns;
  }

  public String toString() {
    String res = "\nClass Title: " + this.title + "\n   Taught By: " + this.teacher + "\n   Description: " +this.desc + "\n   Students are: ";

    for (String student: this.names) {
      res += student + ", ";
    }
    res += "\n" + showAllAssignments();
    return res;
  }

  // ! Other Methods


}
