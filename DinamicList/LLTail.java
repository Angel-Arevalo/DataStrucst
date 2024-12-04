package DinamicList;
import StaticList.ListTail;

class LLTail extends LL implements ListTail {
    private Node tail;

    public LLTail() {
        super();
        tail = null;
    }

    @Override
    public void pushFront(int key) {
        Node ref = new Node(key);
        if (head == null) {
            tail = ref;
        }
        ref.setNext(head);
        head = ref;
    }

    @Override
    public void pushBack(int key) {
        if(tail == null) pushFront(key);
        else {
            Node ref = new Node(key);
            tail.setNext(ref);
            tail = ref;
        }
    }

    @Override
    public void popFinal() {
        if(head == null) System.out.println("Error: No hay elementos");
        else {
            Node ref = head;
            while (ref.getNode().getNode() != null) {
                ref = ref.getNode();
            }

            tail = ref;
            tail.setNext(null);
        }
    }

    @Override
    public void addAfter(int key) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addBefore(int key) {
        // TODO Auto-generated method stub
        
    }
}