package SortedList;

import StaticList.Pila;

public class StackSort<T extends Comparable<T>> {
    private Pila<T> list;

    public StackSort(int length) {
        list = new Pila<T>(length);
    }

    public StackSort() {
        list = new Pila<T>(10);
    }

    public void push(T newItem) {
        if(isEmpty()) {
            list.push(newItem);
            return;
        }
        if(top().compareTo(newItem) == -1) list.push(newItem);
    }

    public T top() {
        return list.top();
    }

    public void pop() {
        list.pop();
    }

    public void print() {
        list.print();
    }

    public int size() {
        return list.size();
    }

    public Boolean isEmpty() {
        return list.isEmpty();
    }
}
