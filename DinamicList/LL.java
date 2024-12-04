package DinamicList;
import StaticList.List;

class LL implements List {
    protected Node head;

    public LL() {
        head = null;
    }

    public void pushFront(int key) {
        Node ref = new Node(key);
        ref.setNext(head);
        head = ref;   
    }

    public void pushBack(int key) {
        if(head == null) {
            pushFront(key);
            Node ref = head;
            while (ref.hasNext()) {
                ref = ref.getNode();
            }

            ref.setNext(new Node(key));
        }
        
    }

    public void popFront() {
        if(head != null) head = head.getNode();
        else System.out.println("Error: Lista vacia. No se puede eliminar el elemento.");
    }

    public void popFinal() {
        if(head == null) System.out.println("Error: Lista vacia. No se puede eliminar el elemento.");
        else if(head.getNode() == null) head = null;
        else {
            Node ref = head;
            while (ref.hasNext() && ref.getNode().getNode() != null) {
                ref = ref.getNode();
            }

            ref.setNext(null);
        }
       
    }

    public void print() {
        Node ref = head;
        System.out.print("Elementos en la lista enlazada: [");
        while (ref != null) {
            System.out.print(ref.getKey() + ((ref.hasNext())? " ": ""));
            ref = ref.getNode();
        }

        System.out.println("]");
    }
}
