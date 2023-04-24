package utils;

import java.util.Scanner;


public class Input {
    private static Scanner myObj = new Scanner(System.in);
    private static String stringInput;
    private static int numInput;

    public Input() {
        Input.myObj = new Scanner(System.in);
    }

    public static Scanner getScanner(){
        return myObj;
    }

    //Retrieves a String response from user
    public static void newStringInput(){
        Input.stringInput = myObj.nextLine().trim();
    }

    // Retrieves an integer response from user
    public static void newIntInput(){
        Input.numInput = myObj.nextInt();
    }

    // Retrieves a String response from user
    public static String getStringInput(){
        return Input.stringInput;
    }

    // Retrieves an integer response from user 
    public static int getNumInput(){
        return Input.numInput;
    }

    // Determines if entry is valid when prompted yes/no questions.
    public static boolean validEntryYesNo(){
        if (Input.stringInput.equalsIgnoreCase("yes") || (Input.stringInput.equalsIgnoreCase("no"))) {
            return true;
        }
        return false;
    }


}
