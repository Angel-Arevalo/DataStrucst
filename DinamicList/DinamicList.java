package DinamicList;
import ListError.*;
import StaticList.ListTest;

public class DinamicList<T> {
    private ListTest<T> list = new ListTest<T>(10);

    public DinamicList(int Length) {
        list = new ListTest<T>(Length);
    }

    public DinamicList() {}

    public void PushBack(T newItem) {
        try {
            list.PushBack(newItem);
        }catch(RuntimeException e) {
            ListTest<T> newList = new ListTest<T>(list.getLength()*2);
            newList.copyList(list);
            list = newList;
            list.PushBack(newItem);
        }
    }

    public void PushFront(T newItem) {
        try {
            list.PushFront(newItem);
        }catch(RuntimeException e) {
            ListTest<T> newList = new ListTest<T>(list.getLength()*2);
            newList.copyList(list);
            list = newList;
            list.PushFront(newItem);
        }
    }

    public void PopBack() {
        list.PopBack();
    }

    public void print() {
        System.out.println(toString());
    }

    public String toString() {
        return list.toString();
    }

    public int size() {
        return list.getCounter();
    }

    public T get(int index) {
        return list.getIndex(index);
    }
}
