package utils;

import java.util.List;
import java.util.Scanner;

public class Input {

  private static Scanner myObj = new Scanner(System.in);
  private static String stringInput;
  private static int numInput;

  public Input() {
    Input.myObj = new Scanner(System.in);
  }

  public static Scanner getScanner() {
    return myObj;
  }

  // Retrieves a String response from user
  public static void newStringInput() {
    String input = myObj.nextLine();
    Input.stringInput = input.toLowerCase().trim();

    // Input.stringInput = myObj.nextLine().trim().toLowerCase();
  }

  // Retrieves an integer response from user
  public static void newIntInput() {
    Input.numInput = myObj.nextInt();
  }

  // Retrieves a String response from user
  public static String getStringInput() {
    return Input.stringInput;
  }

  // Retrieves an integer response from user
  public static int getNumInput() {
    return Input.numInput;
  }

  // Repeatedly asks user for yes, keeps prompting if no or invalid response.
  public static boolean validEntryYesNo() {
    while (true) {
      Input.newStringInput();
      if (Input.stringInput.equals("yes")) {
        return true;
      } else if (Input.stringInput.equals("no")) {
        return false;
      } else {
        System.out.println("Please enter a valid input! (Yes/No)");
      }
    }
  }

  public static String validEntry(List<String> entries) {
    while (true) {
      Input.newStringInput();
      if (entries.contains(Input.stringInput)) {
        return Input.stringInput;
      } else {
        System.out.println("Please enter a valid input!" + "(" + entries + ")");
      }
    }
  }
}
