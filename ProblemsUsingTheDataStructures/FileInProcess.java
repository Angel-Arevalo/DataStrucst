import java.util.Scanner;

public class Main {
    private static StackSort<Integer> list = new StackSort<Integer>();
    private static ReadSelection reader = new ReadSelection();

    public static void main(String[] args) {
        reader.readInt();
        ListTest<Integer> courses = reader.readSelections();

        int g = courses.getIndex(0);
        list.push(g);
        for(int i = 0; i < courses.getLength(); i++) {
            if(g < courses.getIndex(i)) {
                g = courses.getIndex(i);
                list.push(g);
            }
        }

        int size = list.size();
        System.out.println(size);
        
        list.print();
    }
}

class ReadSelection {
    private Scanner input;

    public ReadSelection() {
        input = new Scanner(System.in);
    }

    public String readLine() {
        return input.nextLine();
    }

    public int readInt() {
        return Integer.parseInt(readLine());
    }

    public double readDouble() {
        return Double.parseDouble(readLine());
    }

    public ListTest<Integer> readSelections() {
        String[] stringArr = readLine().split(" ");

        if(stringArr.length == 1 
           && stringArr[0].equals("")) return new ListTest<Integer>(0);
        ListTest<Integer> intArr = new ListTest<Integer>(stringArr.length);

        for(int i = 0; i < intArr.getLength(); i++) {
            intArr.PushBack(Integer.parseInt(stringArr[i]));
        }

        return intArr;
    }

    public void test() {
        System.out.println(readLine() == "");
    }
}

class ListTest<TypeName> {
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
        String toReturn = "";

        for(int i = 0; i < counter; i++) toReturn += list[i] + " "; 
        
        return toReturn;
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

class DinamicList<T> {
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

class StackSort<T extends Comparable<T>> {
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

class Pila<T> {
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

    public Boolean isEmpty() {
        return list.Empty();
    }

    public int size() {
        return list.getCounter();
    }

    public void copy(Pila<T> t) {
        list.copyList(t.list);
    }
}
