import SortedList.OrderList;

public class Main {

    public static void main(String[] args) {
        OrderList<Integer> list = new OrderList<Integer>(10);

        list.insert(1);

        list.print();
    }
}