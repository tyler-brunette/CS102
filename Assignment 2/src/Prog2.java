/*
Tyler Brunette
Login ID: brun6052
CS-102, Winter 2022
Programming Assignment 2
Prog1 class: Handles all user input and calls other classes to execute methods.
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog2 {
    // Scanner to handle all input
    private Scanner scan;

    /*
    Method: main
    Purpose: Calls on methods to execute actions.
    Parameters: String[] args: Contains the directory for the input file
    Returns: N/A
    */
    public static void main(String[] args) {
        // prog2 is an instance of this class used to call methods here.
        Prog2 prog2 = new Prog2();
        ArrayList<Definition> dataList = prog2.parseFile(args[0]);

        // Instance of Database class to call methods
        Database database = new Database();
        database.fillEntries(dataList);
        prog2.getAction(database);
    }

    /*
    Method: parseFile
    Purpose: Takes user input to get the file and parses the file
    Parameters: N/A
    Returns: ArrayList arrayList: ArrayList of all parsed data from the file. Each line is
             separated into individual String Arrays in the list.
    */
    public ArrayList<Definition> parseFile(String path) {

        // ArrayList to store all parsed data from the file.
        ArrayList<Definition> arrayList = new ArrayList<Definition>();
        // validFile represents whether or not the user provided a valid file.
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
        String choice;
        do {
            System.out.print("""
                            
            Please choose one of the following actions:
            "Define": Define a term.\s
            "Search": Search for matching terms.\s
            "Print": Print the entire database.\s
            "Add": Add new definition. \s
            "Exit": Exit the program.
            Your choice?\t""");

            choice = scan.next().toLowerCase();


            // Switch case to choose the action based on the user's input
            switch (choice) {
                case "define" : // Prints definition(s) of provided terms
                    System.out.print("\nEnter a term to define: ");
                    database.getDefinitions(scan.next());
                    break;
                case "search" : // Prints all matching terms to the provided prefix
                    System.out.print("\nEnter a prefix to search: ");
                    database.searchTerms(scan.next());
                    break;
                case "print" : // Prints entire database
                    database.printDatabase();
                    break;
                case "add" : // Adds new definition to the database
                    database.insertDefinition(prog2.createDefinition());
                    break;
                case "exit" : // Do Nothing
                    break;
                default : // Only get here with an invalid input
                    System.out.println("\nError: Invalid input. Please try again.");
                    break;
            }
        } while (!choice.equals("exit")); // Exits do while when the user chooses to exit

    }

    /*
    Method: createDefinition
    Purpose: Creates a definition object based on user input
    Parameters:
    Returns: Definition definition: User defined definition object
    */
    private Definition createDefinition() {
        scan = new Scanner(System.in);

        // New definition object to contain user input
        Definition definition = new Definition();
        System.out.println("Please enter the term you would like to define:");
        // Takes only the first string in the line
        scan.useDelimiter(" ");
        String[] data = scan.delimiter().split(scan.nextLine());
        definition.setTerm(data[0]);
        System.out.println("Please enter the definition for the term:");
        definition.setDef(scan.nextLine());

        // Re-initialize scanner to clear any data
        scan = new Scanner(System.in);
        int seqNum = 0; // User defined sequence number
        // Input validation for a positive integer input
        do {
            System.out.println("Please enter the corresponding sequence number of the definition:");
            try {
                seqNum = Integer.parseInt(scan.next());
            } catch (NumberFormatException invalidInput) {
                seqNum = 0;
            }
            if (seqNum <= 0) {
                System.out.println("Error: Invalid input.");
            }
        }
        while (seqNum <= 0);
        definition.setNumber(seqNum);
        return definition;
    }
}
