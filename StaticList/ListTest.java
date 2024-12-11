package StaticList;
import ListError.*;

public class ListTest<TypeName> {
    protected TypeName[] list;
    protected int counter = 0;

    public ListTest(int length) {
        list = (TypeName[]) new Object[length];
    }

    public ListTest() {
        this(10);
    }

    public void PushFront(TypeName toAdd) {
        if (isFull()) {
            throw new RuntimeException();
        } else {
            for (int i = counter - 1; i >= 0; i--) {
                list[i + 1] = list[i];
            }
            list[0] = toAdd;
            counter++;
        }
    }

    public void PushBack(TypeName toAdd) {
        if (isFull()) {
            throw new RuntimeException();
        } else {
            list[counter] = toAdd;
            counter++;
        }
    }

    public void PopFront() {
        Erase(0);
    }

    public void PopBack() {
        if (counter > 0) {
            counter --;
        } else {
            throw new RuntimeException();
        }
    }

    public void print() {
        System.out.print("Elementos en el arreglo: ");
        System.out.println(toString());
    }

    public int find(TypeName element) {
        for (int i = 0; i < counter; i++) {
            if (element.equals(list[i])) return i;
        }
        return -1;
    }

    public void Erase(int index) {
        if (counter == 0) {
            throw new RuntimeException();
        } else if (index < 0 || index >= counter) {
            throw new RuntimeException();
        } else {
            for (int i = index; i < counter - 1; i++) {
                list[i] = list[i + 1];
            }
            counter--;
        }
    }

    public void AddBefore(TypeName element, int index) {
        if (isFull()) {
            throw new RuntimeException();
        } else if (index < 0 || index > counter + 1) {
            throw new RuntimeException();
        } else {
            for (int i = counter; i > index; i--) {
                list[i] = list[i - 1];
            }
            list[index] = element;
            counter++;
        }
    }

    public void AddAfter(TypeName element, int index) {
        if (isFull()) {
            throw new RuntimeException();
        } else if (index < 0 || index > counter) {
            throw new RuntimeException();
        } else {
            AddBefore(element, index + 1);
        }
    }

    public Boolean Empty() {
        return (counter == 0);
    }

    public int getCounter() {
        return this.counter;
    }

    public void cleanHalf() {
        counter = counter/2;
    }

    public boolean isFull() {
        return (counter == list.length);
    }

    public int getLength() {
        return list.length;
    }

    public String toString() {
        String toReturn = "[";

        for(int i = 0; i < counter; i++) toReturn += list[i] + ((i != counter - 1)? ", ": ""); 
        
        return toReturn + "]";
    }

    public TypeName getIndex(int index) {
        if(index < 0 || counter <= index) throw new RuntimeException();
        return list[index]; 
    }

    public void copyList(ListTest<TypeName> toCopy) {
        for(int i = 0; i < toCopy.counter; i++) list[i] = toCopy.list[i];
    }

    public void set(int index, TypeName newItem) {
        if(index < 0 || counter <= index) throw new RuntimeException();
        list[index] = newItem;
    }
}
