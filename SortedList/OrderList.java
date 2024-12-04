package SortedList;
import StaticList.ListTest;
import ListError.NotSuchElement;

public class OrderList<Type extends Comparable<Type>> implements SortedList<Type> {
    private ListTest<Type> list;

    public OrderList(int lenght) {
        list = new ListTest<Type>(lenght);
    }

    private int search(Type elemet) {
        int index = 0;
        if(empty()) return index;
        for(int  i = 0; i < list.getCounter(); i++) {
            if(list.getIndex(i).compareTo(elemet) == -1 || 
                list.getIndex(i).compareTo(elemet) == 0) index = i;
        }

        return index;
    }

    @Override
    public void insert(Type element) {
        int index = search(element);
        if(index == 0) list.PushFront(element);
        else list.AddAfter(element, index);
    }

    @Override
    public int find(Type elemet) {
        for(int  i = 0; i < list.getCounter(); i++) {
            if(list.getIndex(i).compareTo(elemet) == 0) return i;
        }

        return -1;
    }

    @Override
    public void remove(Type element) {
        int index = find(element);
        if(index < 0) throw new NotSuchElement();

        list.Erase(index);
    }


    @Override
    public Boolean empty() {
        return list.Empty();
    }

    @Override
    public void print() {
        list.print();
    }

    @Override
    public int size() {
        return list.getCounter();
    }

    public String toString() {
        return list.toString();
    }
}
