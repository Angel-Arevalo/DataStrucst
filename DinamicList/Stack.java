package DinamicList;

import StaticList.Pila;

public class Stack<T> {
    private Pila<T> list = new Pila<T>(10);

    public Stack(int length) {
        list = new Pila<T>(length);
    }

    public Stack() {}


    public void push(T toEnc) {
        try {
            list.push(toEnc);
        }catch(RuntimeException e) {
            Pila<T> newStack = new Pila<>(list.size()*2);
            newStack.copy(list);
            list = newStack;
            list.push(toEnc);
        }
    }

    public void pop() {
        list.pop();
    }

    public T top() {
        return list.top();
    }

    public void print() {
        list.print();
    }

    public Boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
