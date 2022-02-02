/*
Tyler Brunette
Login ID: brun6052
CS-102, Winter 2022
Programming Assignment 1
Database class: Interaction between the Definition class and the user.
 */
import java.util.*;

public class Database {
    // dictionary is a Definition array that stores all Definition objects
    private final TermList dictionary;

    public Database() {
        this.dictionary = new TermList();
    }

    /*
        Method: fillEntries
        Purpose: Fills the definition array with the information from the parsed file.
        Parameters:
        ArrayList dataList: contains the parsed data from the file.
        Returns: N/A
        */
    public void fillEntries(ArrayList<Definition> dataList) {
        for (Definition definition : dataList) {
            this.dictionary.addTerm(definition);
        }
    }

    public void insertDefinition(Definition definition) {
        this.dictionary.addTerm(definition);
    }

    /*
    Method: getDefinitions
    Purpose: Prints the definitions of a term entered by the user.
    Parameters:
    String term: Term to define
    Returns: N/A
    */
    public void getDefinitions(String term) {
        System.out.println();
        dictionary.getDefinitions(term);
    }

    /*
    Method: searchTerms
    Purpose: Prints the matching terms that start with the pattern given by the user.
    Parameters:
    String input: Partial term to match to whole terms
    Returns: N/A
    */
    public void searchTerms(String input) {
        System.out.println();
        System.out.println("Matching Terms: \n");
        dictionary.findMatchingTerms(input);

    }

    /*
    Method: printDatabase
    Purpose: Prints the entire database of terms, numbers, and definitions
    Parameters: N/A
    Returns: N/A
    */
    public void printDatabase() {
        System.out.println();
        dictionary.printDatabase();
    }

}
