package DinamicList;

public class Node<T extends Comparable<T>> implements Comparable<T> {
    protected T key;
    protected Node<T> next;

    public Node(T key) {
        this.key = key;
        next = null;
    }

    public T getKey() {
        return this.key;
    }

    public Node<T> getNode() {
        return this.next;
    }

    public void setKey(T newKey) {
        key = newKey;
    }

    public void setNext(Node<T> node) {
        next = node;
    }

    public boolean hasNext() {
        return (next != null); 
    }

    @Override
    public int compareTo(T o) {
        return key.compareTo(o);
    }
}

class NodePrev<T extends Comparable<T>> extends Node<T> {
    private Node<T> prev;

    public NodePrev(T key) {
        super(key);
        prev = null;
    }

    public void setBefore(Node<T> node) {
        prev = node;
    }

    public boolean hasPrev() {
        return (prev != null);
    }
}
