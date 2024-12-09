package SortedList;
import DinamicList.Node;

public class SortedLL<T extends Comparable<T>> implements SortedList<T> {
    private Node<T> head;
    private int length = 0;

    public SortedLL(T item) {
        head = new Node<T>(item);
    }

    public SortedLL() {
        this(null);
    }

    public Node<T> Find(T element) {
        Node<T> ref = head;

        while (ref != null) {
            if(ref.compareTo(element) == 0) return ref;
            ref = ref.getNode();
        }
        return null;
    }

    private Node<T> search(T element) {
        Node<T> prev = null;
        Node<T> ref = head;

        if(head == null) return prev;

        while (ref != null) {
            if(ref.compareTo(element) < 0) prev = ref;
            else if(ref.compareTo(element) == 0) return ref;
            ref = ref.getNode();
        }

        return prev;
    }

    private void pushFront(T newItem) {
        Node<T> item = new Node<T>(newItem);
        item.setNext(head);
        head = item;
    }

    @Override
    public void insert(T newItem) {
        Node<T> toInsert = search(newItem); 
        
        if(toInsert == null) {
            pushFront(newItem);
            return;
        }
        Node<T> item = new Node<T>(newItem);
        Node<T> next = toInsert.getNode();
        toInsert.setNext(item);
        item.setNext(next);
    }

    @Override
    public void remove(T element) {
        
    }

    @Override
    public Boolean empty() {
        return head == null;
    }

    @Override
    public void print() {
        Node<T> ref = head;
        System.out.print("[");
        while (ref != null) {
            System.out.print(ref.getKey() + ((ref.getNode() != null) ? ", ": ""));
            ref = ref.getNode();
        }
        System.out.print("]\n");
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public int find(T element) {
        throw new RuntimeException("Metodo no implementado");

    }
}
