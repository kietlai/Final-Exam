// Implement the following:

//
//

//Imports
import java.util.Scanner;
import java.util.ArrayList;

/**
 * <h1>CLI Interface Class</h1>
 * used to create an cli in the terminal to interact with.
 * @author Quoc-Kiet Lai
 * @since 2024-05-29
 */
public class CLI {
  /**
   * No arguement contructor, is just called once.
   */
  public CLI() {
    System.out.print("Welcome to Academia Lite! \n I hope you enjoy your time here! \n I would like to start out by saying this program doesn't include much outside of the class.");
    System.out.print(" I wanted to keep the program relative simple and uncluttered so that you wouldn't have such a tough time navigating it and the code base.");

    Scanner scan = new Scanner(System.in);

    //Creating the class
    System.out.println("\nLets start by creating your first class !");
    System.out.println("Would you like to auto generate data (Y) or would you like to create your own data (n)");

    String ans = scan.nextLine();

    //Finish creating a selector for the cli
    // Create a function to demostrate the following
    // [] Creating a class arraylist for each teacher
    // [] Create a class for teacher
    // [] Finish the CLI
    if (ans.equalsIgnoreCase("y")) {

    }






  }

  public void createClass() {
    Scanner scan = new Scanner(System.in);

    System.out.println("What should be the title of the class?");
    String title = scan.nextLine();

    System.out.println("What is your name (assuming you are the teacher)?");
    String name = scan.nextLine();

    System.out.println("What is the description of the class?");
    String description = scan.nextLine();

    System.out.println("Now we will move onto your students");


    System.out.println("Would you like to autogenerate students");
    String res = scan.nextLine();
  }
  public ArrayList<String> studentNames() {
    ArrayList<String> studentNames = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    while (!scan.nextLine().equalsIgnoreCase("no")) {
      System.out.print("What is the name of the student? or are you finished respond with \"no\"");
    }
  }

  public void randomDataGeneration() {

  }
}
