/*
Tyler Brunette
Login ID: brun6052
CS-102, Winter 2022
Programming Assignment 2
DefinitionNode class: Stores a single definition and sequence number
 */
public class DefinitionNode {
    private Definition definition;
    private DefinitionNode next;

    /*
    Constructor
    Purpose: Initialize variables
    Parameters: N/A
    Returns: N/A
    */
    public DefinitionNode() {
        this.definition = null;
        this.next = null;
    }

    /*
    Methods: getDefinition, setDefinition
    Purpose: get or set the value of definition.
    Parameters:
    Definition definition: object that contains the definition and sequence number
    Returns:
    definition
    */
    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    /*
    Methods: getNextNode, setNextNode
    Purpose: get or set the value of nextNode.
    Parameters:
    TermNode nextNode: Reference to the next node in the list
    Returns:
    nextNode
    */
    public DefinitionNode getNextNode() {
        return next;
    }

    public void setNextNode(DefinitionNode next) {
        this.next = next;
    }

    /*
    Method: print
    Purpose: Prints the sequence numbers and definitions
    Parameters: N/A
    Returns: N/A
    */
    public void print() {
        System.out.println(definition.toString());
        System.out.println();
    }
}
