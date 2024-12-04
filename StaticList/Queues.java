package StaticList;

public class Queues<T> {
    private T[] list;
    private int front = 0, back = 0, length;
    private int counter = 0;

    public Queues(int length) {
        list = (T[]) new Object[length];
        this.length = length;
    }

    public void addLast(T newItem) {
        if (counter == length) {
            System.out.println("Error: Lista llena. No se puede agregar el elemento.");
            return;
        }
        list[back] = newItem;
        back = (back + 1) % length; 
        counter++;
    }

    public void addFirst(T newItem) {
        if (counter == length) {
            System.out.println("Error: Lista llena. No se puede agregar el elemento.");
            return;  
        }
        front = (front - 1 + length) % length; 
        list[front] = newItem;
        counter++;
    }

    public void removeLast() {
        if (counter == 0) {
            System.out.println("Error: Lista vacia. No se puede eliminar el elemento.");
            return;
        }
        back = (back - 1 + length) % length; 
        counter--;
    }

    public void removeFirst() {
        if (counter == 0) {
            System.out.println("Error: Lista vacia. No se puede eliminar el elemento.");
            return;
        }
        front = (front + 1) % length;
        counter--;
    }

    public void print() {
        System.out.print("Elementos en el arreglo: [");

        int i = front;
        int c = 0;
        while (c < counter) {
            System.out.print(list[i].toString());
            i = (i + 1) % length;
            if (c < counter - 1) System.out.print(" "); // Only space between elements
            c++;
        }
        System.out.println("]");
    }
}
