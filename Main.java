import SortedList.OrderList;

public class Main {

    public static void main(String[] args) {

        OrderList<String> list = new OrderList<String>(10);

        list.insert("world");
        list.insert("Hello");
        list.insert("Hijo");
        list.insert("de");
        list.insert("fruta");
        list.insert("hala");
        list.print();
    }
}