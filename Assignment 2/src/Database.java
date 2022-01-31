/*
Tyler Brunette
Login ID: brun6052
CS-102, Winter 2022
Programming Assignment 1
Database class: Interaction between the Definition class and the user.
 */
import java.util.*;

public class Database {
    // entries is a Definition array that stores all Definition objects
    private final Definition[] entries;

    /*
    Constructor
    Purpose: Set the length of the final definition array
    Parameters:
    int length: Length of the parsed file
     */
    Database(int length) {
        this.entries = new Definition[length];
    }

    /*
    Method: fillEntries
    Purpose: Fills the definition array with the information from the parsed file.
    Parameters:
    ArrayList dataList: contains the parsed data from the file.
    Returns: N/A
    */
    public void fillEntries(ArrayList<String[]> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            // Instance of the Definition class to fill entries.
            Definition definition = new Definition();
            definition.setObject(dataList.get(i));
            this.entries[i] = definition;
        }
    }


    /*
    Method: define
    Purpose: Prints the definition of a term entered by the user.
    Parameters:
    String term: Term to define
    Returns: N/A
    */
    public void define(String term) {
        System.out.println();
        // match boolean shows whether there is a matching term to the user's input
        boolean match = false;
        for (Definition entry : entries) {
            if (entry.getTerm().toLowerCase().equals(term.toLowerCase())) {
                System.out.println(entry.toString());
                match = true;
            }
        }
        if (!match) {
            System.out.println("No matching terms found.");
        }
    }

    /*
    Method: searchTerms
    Purpose: Prints the matching terms that start with the pattern given by the user.
    Parameters:
    String input: Partial term to match to whole terms
    Returns: N/A
    */
    public void searchTerms(String input) {
        // matchingTerms collects all terms that match the input given by the user.
        ArrayList<String> matchingTerms = new ArrayList<String>();
        System.out.println();
        for (Definition entry : entries) {
            boolean doesNotMatch = false;

            for (int index = 0; index < input.length(); index++) {
                if (entry.getTerm().charAt(index) != input.charAt(index)) {
                    doesNotMatch = true;
                    break;
                }
            }
            if (!matchingTerms.contains(entry.getTerm()) && !doesNotMatch) {
                matchingTerms.add(entry.getTerm());
            }
        }
        if (matchingTerms.isEmpty()){
            System.out.println("No matching terms found.");
        } else {
            System.out.println("Matching Terms: ");
            for (int i = 0; i < matchingTerms.size(); i++) {
                System.out.println(matchingTerms.get(i));
            }
        }

    }

    /*
    Method: printDatabase
    Purpose: Prints the entire database of terms, numbers, and definitions
    Parameters: N/A
    Returns: N/A
    */
    public void printDatabase() {
        System.out.println();
        for (Definition entry : entries) {
            System.out.println(entry.toString());

        }
    }

}
