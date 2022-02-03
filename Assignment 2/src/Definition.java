/*
Tyler Brunette
Login ID: brun6052
CS-102, Winter 2022
Programming Assignment 2
Definition class: Stores a single term, number, and definition
 */
import static java.lang.Integer.parseInt;

public class Definition {

    private String term;
    private int number;
    private String def;

    /*
    Methods: getTerm, setTerm
    Purpose: get or set the value of term.
    Parameters:
    String data: String to set term equal to
    Returns:
    term
    */
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    /*
    Methods: getNumber, setNumber
    Purpose: get or set the value of number.
    Parameters:
    int number: sequence number of a term's definition
    Returns:
    number
    */
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    /*
    Methods: getDef, setDef
    Purpose: get or set the value of def.
    Parameters:
    String def: definition of a term
    Returns:
    def
    */
    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
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
        return  " (" + number + ") " + def;
    }
}
