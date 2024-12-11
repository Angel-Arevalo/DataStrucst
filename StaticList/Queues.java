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
            throw new RuntimeException("Error: Lista llena. No se puede agregar el elemento.");
        }
        list[back] = newItem;
        back = (back + 1) % length; 
        counter++;
    }

    public void addFirst(T newItem) {
        if (counter == length) {
            throw new RuntimeException("Error: Lista llena. No se puede agregar el elemento.");
        }
        front = (front - 1 + length) % length; 
        list[front] = newItem;
        counter++;
    }

    public void removeLast() {
        if (counter == 0) {
            throw new RuntimeException("Error: Lista vacia. No se puede eliminar el elemento.");
        }
        back = (back - 1 + length) % length; 
        counter--;
    }

    public void removeFirst() {
        if (counter == 0) {
            throw new RuntimeException("Error: Lista vacia. No se puede eliminar el elemento.");
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
            if (c < counter - 1) System.out.print(" ");
            c++;
        }
        System.out.println("]");
    }

    public void copy(Queues<T> another) {
        back = 0;
        for(int i = 0, j = another.front; i < another.counter; i++, j = (j+1)%another.length) {
            list[i] = another.list[j];
            back ++;
        }

        counter = another.counter;
    }

    public int getLength() {
        return list.length;
    }

    public int getCounter() {
        return counter;
    }
}
