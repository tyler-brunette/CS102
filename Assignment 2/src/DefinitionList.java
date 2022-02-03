/*
Tyler Brunette
Login ID: brun6052
CS-102, Winter 2022
Programming Assignment 2
DefinitionList class: Contains methods to interact between multiple instances of DefinitionNode
 */
public class DefinitionList {
    private DefinitionNode head; // head of list

    /*
    Method: addDefinition
    Purpose: Adds a DefinitionNode if the definition is not already in the list.
    Parameters:
    Definition definition: Definition object that contains the term, sequence number, and definition.
    Returns: N/A
    */
    public void addDefinition(Definition definition) {
        DefinitionNode currNode = this.head; // current node in list
        DefinitionNode prevNode = null; // previous node in list
        DefinitionNode splice; // node to insert into list

        int seqNum = definition.getNumber(); // Sequence number of new definition object

        // Insert term node at head if list is empty
        if (currNode == null) {
            splice = new DefinitionNode();
            splice.setDefinition(definition);
            this.head = splice;
        }
        else {
            // Sorting Loop runs until the end of the list
            while (currNode != null) {
                int currSeqNum = currNode.getDefinition().getNumber(); // Sequence number of current node

                // If the sequence number already exists, print an error and exit the method.
                if (currSeqNum == seqNum) {
                    System.out.println("Error: Sequence number already exists for this term.");
                    return ; // Exits the method
                }
                // If the sequence number is greater than the current node sequence number, move to next node
                else if (currSeqNum < seqNum) {
                    prevNode = currNode;
                    currNode = currNode.getNextNode();
                }
                else {
                    break;
                }
            }
            // Add node at front of list
            if (currNode != null && prevNode == null) {
                splice = new DefinitionNode();
                splice.setDefinition(definition);
                this.head = splice;
                splice.setNextNode(currNode);
            }
            // Add node at end of list
            else if (currNode == null) {
                splice = new DefinitionNode();
                splice.setDefinition(definition);
                prevNode.setNextNode(splice);
            }
            // Add node in middle of list
            else {
                splice = new DefinitionNode();
                splice.setDefinition(definition);
                splice.setNextNode(currNode);
                prevNode.setNextNode(splice);
            }
        }

    }

    /*
    Method: printList
    Purpose: Prints the list of sequence numbers and definitions
    Parameters: N/A
    Returns: N/A
    */
    public void printList() {
        DefinitionNode currNode = this.head; // current node in list

        // Print if list is empty
        if (currNode == null) {
            System.out.println("No definitions found.");
        }
        else {
            // Loop runs until the end of the list
            while (currNode != null) {
                currNode.print();
                currNode = currNode.getNextNode();
            }
        }
    }
}
