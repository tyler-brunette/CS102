public class TermNode {
    private String term;
    private TermNode nextNode;
    private DefinitionList definitionList;

    // Constructor to create a new node
    // Next is by default initialized
    // as null
    TermNode() {
        this.term = null;
        this.nextNode = null;
        this.definitionList = new DefinitionList();
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String data) {
        this.term = data;
    }

    public TermNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(TermNode nextNode) {
        this.nextNode = nextNode;
    }

    public DefinitionList getDefinitionList() {
        return definitionList;
    }

    public void addDefinition(Definition definition) {
        this.definitionList.addDefinition(definition);
    }

    public void printDefinitions() {
        this.definitionList.printList();
    }
}
