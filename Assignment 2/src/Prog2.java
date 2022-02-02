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
import java.util.InputMismatchException;
import java.util.Scanner;

public class Prog2 {
    // Scanner to handle all input
    private Scanner scan;

    /*
    Method: main
    Purpose: Calls on methods to execute actions.
    Parameters: String[] args: Not used
    Returns: N/A
    */
    public static void main(String[] args) {
        // prog2 is an instance of this class used to call methods here.
        Prog2 prog2 = new Prog2();
        ArrayList<Definition> dataList = prog2.parseFile(args[0]);

        Database database = new Database();
        database.fillEntries(dataList);
        prog2.getAction(database);
    }

    /*
    Method: parseFile
    Purpose: Takes user input to get the file from the current directory and parses the file
    Parameters: N/A
    Returns: ArrayList arrayList: ArrayList of all parsed data from the file. Each line is
             separated into individual String Arrays in the list.
    */
    public ArrayList<Definition> parseFile(String path) {

        // ArrayList to store all parsed data from the file.
        ArrayList<Definition> arrayList = new ArrayList<Definition>();
        // validFile represents whether or not the user gave a valid file in the current directory.
        boolean validFile = false;
        do {
            File file = new File(path);

            try {
                scan = new Scanner(file);
                validFile = true;
            } catch (IOException ioException) {
                System.out.println("File not valid");
                System.exit(-1);
            }
        } while (!validFile);

        while (scan.hasNextLine()) {
            scan.useDelimiter("/");
            String[] data = scan.delimiter().split(scan.nextLine());
            Definition definition = new Definition();
            definition.setObject(data);
            arrayList.add(definition);
        }
        return arrayList;
    }

    /*
    Method: getAction
    Purpose: Handles user input to decide what action to execute.
    Parameters: Database database: Contains methods to execute on data.
    Returns: N/A
    */
    public void getAction(Database database){

        Prog2 prog2 = new Prog2();
        scan = new Scanner(System.in);
        // choice contains the user input after they are prompted to choose an action
        int choice;
        do {
            System.out.print("""
                            
            Please choose one of the following actions:
            1. Define a term.\s
            2. Search for matching terms.\s
            3. Print the entire database.\s
            4. Add new definition. \s
            9. Exit the program.
            Your choice?\t""");

            // Error handling for user input
            try {
                choice = Integer.parseInt(scan.next());
            } catch (NumberFormatException invalidInput) {
                choice = 0;
            }

            // Switch case to choose the action based on the user's input
            switch (choice) {
                case 1 :
                    System.out.print("\nEnter a term to define: ");
                    database.getDefinitions(scan.next());
                    break;
                case 2 :
                    System.out.print("\nEnter a prefix to search: ");
                    database.searchTerms(scan.next());
                    break;
                case 3 :
                    database.printDatabase();
                    break;
                case 4 :
                    database.insertDefinition(prog2.createDefinition());
                    break;
                case 9 :
                    break;
                default :
                    System.out.println("\nError: Invalid input. Please try again.");
                    break;
            }
        } while (choice != 9); // Exits do while when the user chooses 9

    }

    private Definition createDefinition() {
        scan = new Scanner(System.in);

        Definition definition = new Definition();
        System.out.println("Please enter the term you would like to define:");
        scan.useDelimiter(" ");
        String[] data = scan.delimiter().split(scan.nextLine());
        definition.setTerm(data[0]);
        System.out.println("Please enter the definition for the term:");
        definition.setDef(scan.nextLine());

        int seqNum = 0;
        do {
            System.out.println("Please enter the corresponding sequence number of the definition:");
            try {
                seqNum = Integer.parseInt(scan.next());
            } catch (NumberFormatException invalidInput) {
                seqNum = 0;
            }
        }
        while (seqNum <= 0);
        definition.setNumber(seqNum);
        return definition;
    }
}
