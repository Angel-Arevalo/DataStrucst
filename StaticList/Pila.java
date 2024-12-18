package StaticList;

public class Pila<T> {
    protected ListTest<T> list;

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

    public Boolean isEmpty() {
        return list.Empty();
    }

    public int size() {
        return list.getCounter();
    }

    public void copy(Pila<T> t) {
        list.copyList(t.list);
    }
    
    public T ptp() {
        T l = top();
        pop();
        return l;
    }
}
