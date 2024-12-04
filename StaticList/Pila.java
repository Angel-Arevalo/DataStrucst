package StaticList;

public class Pila<T> {
    ListTest<T> list;

    public Pila(int length) {
        list = new ListTest<T>(length);
    }

    public void push(T type) {
        list.PushBack(type);
    }

    public void pop() {
        list.PopBack();
    }

    public T top() {
        return list.getIndex(list.getCounter() - 1);
    }

    public void print() {
        list.print();
    }
}