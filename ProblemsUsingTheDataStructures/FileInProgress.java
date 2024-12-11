import java.util.Scanner;

class Main {
    private static ReadSelection reader = new ReadSelection();
    private static ListTest<String> list;

    public static void main(String[] args) {
        list = new ListTest<String>(reader.readInt());

        for(int i = 0; i < list.getLength(); i++) {
            list.PushBack(reader.readLine());
        }

        int last = -1;

        do {
            ListTest<Integer> options = reader.readSelections();
            if(options.getLength() == 0) break;
            if(options.getIndex(0) < 0 || options.getIndex(1) < 0 
              || list.getLength() < options.getIndex(0) || list.getLength() < options.getIndex(1)) {
                break;
            } 
            last = options.getIndex(0);
            int f = options.getIndex(1);
            String newString =  list.getIndex(last - 1) + list.getIndex(f - 1);
            list.set(f - 1, "");
            list.set(last - 1, newString);
        }while(true);

        if(last != -1)System.out.println(list.getIndex(last - 1));
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
