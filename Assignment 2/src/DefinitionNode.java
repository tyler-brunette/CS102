public class DefinitionNode {
    private Definition definition;
    private DefinitionNode next;

    public DefinitionNode() {
        this.definition = null;
        this.next = null;
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    public DefinitionNode getNextNode() {
        return next;
    }

    public void setNextNode(DefinitionNode next) {
        this.next = next;
    }

    public void print() {
        System.out.println(definition.toString());
        System.out.println();
    }
}
