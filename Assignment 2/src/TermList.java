/*
Tyler Brunette
Login ID: brun6052
CS-102, Winter 2022
Programming Assignment 2
TermList class: Contains methods to interact between multiple instances of TermNode
 */
public class TermList {
    private TermNode head; // head of list

    /*
    Method: addTerm
    Purpose: Adds a TermNode if the term is not already in the list.
             Also adds the definition and sequence number of the term.
    Parameters:
    Definition definition: Definition object that contains the term, sequence number, and definition.
    Returns: N/A
    */
    public void addTerm(Definition definition) {
        TermNode currNode = this.head; // current node in list
        TermNode prevNode = null; // previous node in list
        TermNode splice; // node to insert into list


        String term = definition.getTerm(); // Term of new definition object

        // Insert term node at head if list is empty
        if (currNode == null) {
            splice = new TermNode();
            splice.setTerm(term);
            splice.addDefinition(definition);
            this.head = splice;
        }
        else {
            // Sorting Loop runs until the end of the list
            while (currNode != null) {
                String currTerm = currNode.getTerm(); // Term of the current node

                // If the term already exists, add a new definition to the node
                if (currTerm.compareToIgnoreCase(term) == 0) {
                    currNode.addDefinition(definition);
                    return ; // Exits the method
                }
                // If the term is alphabetically after the current node term, move to next node
                else if (currTerm.compareToIgnoreCase(term) < 0) {
                    prevNode = currNode;
                    currNode = currNode.getNextNode();
                }
                else {
                    break;
                }
            }
            // Add node at front of list
            if (currNode != null && prevNode == null) {
                splice = new TermNode();
                splice.setTerm(term);
                splice.addDefinition(definition);
                this.head = splice;
                splice.setNextNode(currNode);
            }
            // Add node at end of list
            else if (currNode == null) {
                splice = new TermNode();
                splice.setTerm(term);
                splice.addDefinition(definition);
                prevNode.setNextNode(splice);
            }
            // Add node in middle of list
            else {
                splice = new TermNode();
                splice.setTerm(term);
                splice.addDefinition(definition);
                splice.setNextNode(currNode);
                prevNode.setNextNode(splice);
            }
        }
    }

    /*
    Method: getDefinitions
    Purpose: Prints the definitions of a term entered by the user.
    Parameters:
    String term: Term to define
    Returns: N/A
    */
    public void getDefinitions(String term) {
        TermNode currNode = this.head; // current node in list

        // Print if list is empty
        if (currNode == null) {
            System.out.println("Term not found.");
        }

        // Loop runs until the end of the list
        while (currNode != null) {
            String currTerm = currNode.getTerm(); // Term of the current node
            // If the list contains the user's term, print the definitions
            if (currTerm.compareToIgnoreCase(term) == 0) {
                System.out.println(term + ": \n");
                currNode.printDefinitions();
                return ; // Exits the method
            }
            else {
                // Move through the list if the terms do not match
                currNode = currNode.getNextNode();
            }
        }
        // Prints if list does not contain the term
        System.out.println("Term not found.");
    }

    /*
    Method: printDatabase
    Purpose: Prints the entire database of terms, sequence numbers, and definitions
    Parameters: N/A
    Returns: N/A
    */
    public void printDatabase() {
        TermNode currNode = this.head; // current node in list

        // Print if list is empty
        if (currNode == null) {
            System.out.println("No terms found.");
        }

        // Loop runs until the end of the list
        while (currNode != null) {
            String currTerm = currNode.getTerm(); // Term of the current node
            System.out.println(currTerm + ": \n");
            currNode.printDefinitions();
            currNode = currNode.getNextNode();

        }
    }

    /*
    Method: findMatchingTerms
    Purpose: Prints the matching terms that start with the pattern given by the user.
    Parameters:
    String input: Partial term to match to whole terms
    Returns: N/A
    */
    public void findMatchingTerms(String input) {
        TermNode currNode = this.head; // current node in list

        // Print if list is empty
        if (currNode == null) {
            System.out.println("No terms found.");
        }

        // Loop runs until the end of the list
        while (currNode != null) {
            String currTerm = currNode.getTerm(); // Term of the current node
            boolean doesNotMatch = false; // Represents whether or not there is a matching term

            // for loop goes through individual characters of the terms
            for (int index = 0; index < input.length(); index++) {
                // If no entry contains the user's input doesNotMatch is set to true
                if (currTerm.charAt(index) != input.charAt(index)) {
                    doesNotMatch = true;
                    break;
                }
            }
            // Print the current node's term if the terms match
            if (!doesNotMatch) {
                System.out.println(currTerm);
            }
            // Move to the next node in the list
            currNode = currNode.getNextNode();
        }
    }
}
