/*
Tyler Brunette
Login ID: brun6052
CS-102, Winter 2022
Programming Assignment 1
Prog1 class: Handles all user input and calls other classes to execute methods.
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog1 {
    // Scanner to handle all input
    private Scanner scan;

    /*
    Method: main
    Purpose: Calls on methods to execute actions.
    Parameters: String[] args: Not used
    Returns: N/A
    */
    public static void main(String[] args) {
        // prog1 is an instance of this class used to call methods here.
        Prog1 prog1 = new Prog1();
        ArrayList<String[]> dataList = prog1.parseFile();

        Database dictionary = new Database(dataList.size());
        dictionary.fillEntries(dataList);
        prog1.getAction(dictionary);
    }

    /*
    Method: parseFile
    Purpose: Takes user input to get the file from the current directory and parses the file
    Parameters: N/A
    Returns: ArrayList arrayList: ArrayList of all parsed data from the file. Each line is
             separated into individual String Arrays in the list.
    */
    public ArrayList<String[]> parseFile() {

        // ArrayList to store all parsed data from the file.
        ArrayList<String[]> arrayList = new ArrayList<String[]>();
        // validFile represents whether or not the user gave a valid file in the current directory.
        boolean validFile = false;
        do {
            scan = new Scanner(System.in);
            System.out.println("What is the name of the file in the current directory that contains the database to use?");
            File file = new File(System.getProperty("user.dir") + "\\" + this.scan.next());

            try {
                scan = new Scanner(file);
                validFile = true;
            } catch (IOException ioException) {
                System.out.println("Error: File name not found in the current directory. Please try again.");
            }
        } while (!validFile);

        while (scan.hasNextLine()) {
            scan.useDelimiter("/");
            String[] data = scan.delimiter().split(scan.nextLine());
            arrayList.add(data);
        }
        return arrayList;
    }

    /*
    Method: getAction
    Purpose: Handles user input to decide what action to execute.
    Parameters: Database dictionary: Contains methods to execute on data.
    Returns: N/A
    */
    public void getAction(Database dictionary){

        scan = new Scanner(System.in);
        // choice contains the user input after they are prompted to choose an action
        int choice;
        do {
            System.out.print("""
                            
            Please choose one of the following actions:
            1. Define a term.\s
            2. Search for matching terms.\s
            3. Print the entire database.\s
            9. Exit the program.
            Your choice?\t""");

            try {
                choice = Integer.parseInt(scan.next());
            } catch (NumberFormatException invalidInput) {
                choice = 0;
            }

            switch (choice) {
                case 1 :
                    System.out.print("\nEnter a term to define: ");
                    dictionary.define(scan.next());
                    break;
                case 2 :
                    System.out.print("\nEnter a prefix to search: ");
                    dictionary.searchTerms(scan.next());
                    break;
                case 3 :
                    dictionary.printDatabase();
                    break;
                default :
                    System.out.println("\nError: Invalid input. Please try again.");
                    break;
            }
        } while (choice != 9);

    }
}
