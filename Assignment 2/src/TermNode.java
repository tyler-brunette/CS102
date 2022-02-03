/*
Tyler Brunette
Login ID: brun6052
CS-102, Winter 2022
Programming Assignment 2
TermNode class: Stores a single term and a reference to the corresponding DefinitionList
 */
public class TermNode {
    private String term;
    private TermNode nextNode;
    private DefinitionList definitionList;

    /*
    Constructor
    Purpose: Initialize variables
    Parameters: N/A
    Returns: N/A
    */
    TermNode() {
        this.term = null;
        this.nextNode = null;
        this.definitionList = new DefinitionList();
    }

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

    public void setTerm(String data) {
        this.term = data;
    }

    /*
    Methods: getNextNode, setNextNode
    Purpose: get or set the value of nextNode.
    Parameters:
    TermNode nextNode: Reference to the next node in the list
    Returns:
    nextNode
    */
    public TermNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(TermNode nextNode) {
        this.nextNode = nextNode;
    }

    /*
    Method: addDefinition
    Purpose: Adds a definition object to definitionList.
    Parameters:
    Definition definition: Definition object to add to definitionList.
    Returns: N/A
    */
    public void addDefinition(Definition definition) {
        this.definitionList.addDefinition(definition);
    }

    /*
    Method: printDefinitions
    Purpose: Prints the sequence numbers and definitions for the term
    Parameters: N/A
    Returns: N/A
    */
    public void printDefinitions() {
        this.definitionList.printList();
    }
}
