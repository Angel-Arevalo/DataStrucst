import java.util.Scanner;
final class Main {
    private static ReadSelection x = new ReadSelection();
    private static Boolean execute = true;
    private static ListTest<Integer> list;
    private static OrderList<Integer> orderList;
    public static void main(String[] args) {
        
        do {
            list = x.readSelections();
            if(list.getLength() == 0) execute = false;
            else if(list.getLength() == 1) {
                if(list.getIndex(0) == 1) System.out.println("Jolly");
                else System.out.println("Not jolly");
            }else {
                orderList = new OrderList<Integer>(list.getLength());
                verify();
            }
        }while(execute);
    }

    public static void verify() {
        for(int i = 0; i < list.getLength() - 1; i++) {
            int l = Math.abs(list.getIndex(i) - list.getIndex(i + 1));
            orderList.insert(l);
        }

        jolly();
    }

    public static void jolly() {
        for(int i = 1; i <= list.getLength() - 1; i++) {
            if(i != orderList.get(i - 1)) {
                System.out.println("Not jolly");
                return;
            }
        }

        System.out.println("Jolly");
    }
}

class OrderList<Type extends Comparable<Type>> {
    private ListTest<Type> list;

    public OrderList(int lenght) {
        list = new ListTest<Type>(lenght);
    }

    private int search(Type element) {
        int index = 0;
        for (int i = 0; i < list.getCounter(); i++) {
            if (list.getIndex(i).compareTo(element) == -1) {
                index = i;
            }
            else if(list.getIndex(i).compareTo(element) == 0) return -1;
        }
        return index;
    }

    public void insert(Type element) {
        int index = search(element);
        if(index == -1) return;
        if(index == 0) list.PushFront(element);
        else list.AddAfter(element, index);

        print();
    }

    public int find(Type elemet) {
        for(int  i = 0; i < list.getCounter(); i++) {
            if(list.getIndex(i).compareTo(elemet) == 0) return i;
        }

        return -1;
    }

    public void remove(Type element) {
        int index = find(element);
        if(index < 0) throw new RuntimeException();

        list.Erase(index);
    }


    public Boolean empty() {
        return list.Empty();
    }

    public void print() {
        list.print();
    }

    public int size() {
        return list.getCounter();
    }

    public Type get(int index) {
        return list.getIndex(index);
    }

    public String toString() {
        return list.toString();
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
        for(int i = 0; i < toCopy.list.length; i++) list[i] = toCopy.list[i];
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
