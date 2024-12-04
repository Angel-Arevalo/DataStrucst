package DinamicList;
class Node {
    protected int key;
    protected Node next;

    public Node(int key) {
        this.key = key;
        next = null;
    }

    public int getKey() {
        return this.key;
    }

    public Node getNode() {
        return this.next;
    }

    public void setKey(int newKey) {
        key = newKey;
    }

    public void setNext(Node node) {
        next = node;
    }

    public boolean hasNext() {
        return (next != null)? true: false; 
    }
}

class NodePrev extends Node {
    private Node prev;

    public NodePrev(int key) {
        super(key);
        prev = null;
    }

    public void setBefore(Node node) {
        prev = node;
    }

    public boolean hasPrev() {
        return (prev != null) ? true: false;
    }
}