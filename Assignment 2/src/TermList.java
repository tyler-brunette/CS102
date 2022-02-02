public class TermList {
    private TermNode head; // head of list

    public void addTerm(Definition definition) {
        TermNode currNode = this.head;
        TermNode prevNode = null;
        TermNode splice;

        String term = definition.getTerm();
        if (currNode == null) {
            splice = new TermNode();
            splice.setTerm(term);
            splice.addDefinition(definition);
            this.head = splice;
        }
        else {
            // Sorting Loop
            while (currNode != null) {
                String currTerm = currNode.getTerm();
                if (currTerm.compareToIgnoreCase(term) == 0) {
                    currNode.addDefinition(definition);
                    return ;
                }
                else if (currTerm.compareToIgnoreCase(term) < 0) {
                    prevNode = currNode;
                    currNode = currNode.getNextNode();
                }
                else {
                    break;
                }
            }
            if (currNode != null && prevNode == null) {
                splice = new TermNode();
                splice.setTerm(term);
                splice.addDefinition(definition);
                this.head = splice;
                splice.setNextNode(currNode);
            }
            else if (currNode == null) {
                splice = new TermNode();
                splice.setTerm(term);
                splice.addDefinition(definition);
                prevNode.setNextNode(splice);
            }
            else {
                splice = new TermNode();
                splice.setTerm(term);
                splice.addDefinition(definition);
                splice.setNextNode(currNode);
                prevNode.setNextNode(splice);
            }
        }
    }

    public void getDefinitions(String term) {
        TermNode currNode = this.head;

        if (currNode == null) {
            System.out.println("Term not found.");
        }

        while (currNode != null) {
            String currTerm = currNode.getTerm();
            if (currTerm.compareToIgnoreCase(term) == 0) {
                System.out.println(term + ": \n");
                currNode.printDefinitions();
                return ;
            }
            else {
                currNode = currNode.getNextNode();
            }
        }
        System.out.println("Term not found.");
    }

    public void printDatabase() {
        TermNode currNode = this.head;

        if (currNode == null) {
            System.out.println("No terms found.");
        }

        while (currNode != null) {
            String currTerm = currNode.getTerm();
            System.out.println(currTerm + ": \n");
            currNode.printDefinitions();
            currNode = currNode.getNextNode();

        }
    }
    public void findMatchingTerms(String input) {
        TermNode currNode = this.head;

        if (currNode == null) {
            System.out.println("No terms found.");
        }

        while (currNode != null) {
            String currTerm = currNode.getTerm();
            boolean doesNotMatch = false;

            // Inner for loop goes through individual characters of the dictionary
            for (int index = 0; index < input.length(); index++) {
                // If no entry contains the user's input doesNotMatch is set to true
                if (currTerm.charAt(index) != input.charAt(index)) {
                    doesNotMatch = true;
                    break;
                }
            }
            if (!doesNotMatch) {
                System.out.println(currTerm);
            }
            currNode = currNode.getNextNode();
        }
    }
}
