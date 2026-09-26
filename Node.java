public class Node {

    int row;
    int column;
    Node parent;

    public Node(int row, int column) {
        this.row = row;
        this.column = column;
        this.parent = null;
    }

    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}