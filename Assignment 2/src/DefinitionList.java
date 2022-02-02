public class DefinitionList {
    private DefinitionNode head; // head of list

    public DefinitionList() {
        this.head = null;
    }

    public void addDefinition(Definition definition) {
        DefinitionNode currNode = this.head;
        DefinitionNode prevNode = null;
        DefinitionNode splice;

        int seqNum = definition.getNumber();

        if (currNode == null) {
            splice = new DefinitionNode();
            splice.setDefinition(definition);
            this.head = splice;
        }
        else {
            // Sorting Loop
            while (currNode != null) {
                int currSeqNum = currNode.getDefinition().getNumber();
                if (currSeqNum == seqNum) {
                    System.out.println("Error: Sequence number already exists for this term.");
                    return ;
                }
                else if (currSeqNum < seqNum) {
                    prevNode = currNode;
                    currNode = currNode.getNextNode();
                }
                else {
                    break;
                }
            }
            if (currNode != null && prevNode == null) {
                splice = new DefinitionNode();
                splice.setDefinition(definition);
                this.head = splice;
                splice.setNextNode(currNode);
            }
            else if (currNode == null) {
                splice = new DefinitionNode();
                splice.setDefinition(definition);
                prevNode.setNextNode(splice);
            }
            else {
                splice = new DefinitionNode();
                splice.setDefinition(definition);
                splice.setNextNode(currNode);
                prevNode.setNextNode(splice);
            }
        }

    }

    public void printList() {
        DefinitionNode currNode = this.head;

        if (currNode == null) {
            System.out.println("No definitions found.");
        }
        else {
            while (currNode != null) {
                currNode.print();
                currNode = currNode.getNextNode();
            }
        }
    }
}
