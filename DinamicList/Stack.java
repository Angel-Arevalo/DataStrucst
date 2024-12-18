package DinamicList;

import StaticList.ListTest;
import StaticList.Pila;

public class Stack<T> extends Pila<T> {

    public Stack(int length) {
        super(length);
    }

    public Stack() {
        super(10);
    }

    @Override
    public void push(T toEnc) {
        if(list.getCounter() < list.getLength()) {
            super.push(toEnc);
        }else {
            ListTest<T> newStack = new ListTest<>(list.getLength()*2);
            newStack.copyList(list);
            list = newStack;
            super.push(toEnc);
        }
    }
}
