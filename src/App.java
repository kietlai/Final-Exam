// CLASS: AP Computer Science A w/ Mr. Chastain
// Period: A2
// By: Quoc-Kiet Lai
// INFO: Making a basic schoology api replica

// It will have classes: (ALL STARRED POINTS ARE GOING TO BE MADE INTO CLASSES)

// School
// - Classes
// - Princpal
// - Average GPA
// - Testing Scores

// Class
// - Student Grade Average
// -Students
// - Teacher
// - Assignments/Tests, use a or 3d/2d array maybe a new object class?

// Student
// - Assignments, reference?DQRD
// - Age
// - Graduation Reqsd

// Assignment GroupsDQR
// - Group Name
// - Assignment Weight2

// Assignments
// - Title
// - Earned Grade
// - Full Grade
// - Letter Grade

public class App {
  public static void main(String[] args) throws Exception {

    String[] studentNames = {"John", "Jim", "Tim", "Jeff", "Ying"};
    Class compsci = new Class("AP Computer Science A", "Steven Chastain", "An AP class that teaches primarly java and helps to introduce the ideas of Object Oriented Programming", studentNames);
    compsci.newAssignment("DQR 1", 10);
    compsci.newAssignment("DQR 2", 24);


    //compsci.getAssignment();

    compsci.getAssignment().editGradeEarnedPoints();
    System.out.println(compsci.getAssignment());



  }
}