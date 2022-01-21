/*
Tyler Brunette
Login ID: brun6052
CS-102, Winter 2022
Programming Assignment 1
Definition class: Stores a single term, number, and definition
 */
import static java.lang.Integer.parseInt;

public class Definition {

    private String term;
    private int number;
    private String def;

    /*
    Method: getTerm
    Purpose: Returns the term
    Parameters: N/A
    Returns: String term
    */
    public String getTerm() {
        return term;
    }

    /*
    Method: setObject
    Purpose: Prints the entire database of terms, numbers, and definitions
    Parameters: String Array entry: contains the term, number, and definition for a term
    Returns: N/A
    */
    public void setObject(String[] entry){
        this.term = entry[0];
        this.number = parseInt(entry[1]);
        this.def = entry[2];

    }

    /*
    Method: toString
    Purpose: Returns a readable string containing all information about the object
    Parameters: N/A
    Returns: String: Readable form of the info about the object
    */
    @Override
    public String toString() {
        return  term + ": (" +
                number +
                ") " + def;
    }
}
