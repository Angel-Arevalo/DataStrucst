package ProblemsUsingTheDataStructures;

import ReadSelection.ReadSelection;
import StaticList.ListTest;
import SortedList.OrderList;


final class JollyProblem {
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
        if(orderList.size() != list.getLength() - 1) {
            System.out.println("Not jolly");
            return;
        }

        for(int i = 1; i < orderList.size(); i++) {
            if(i != orderList.get(i - 1)) {
                System.out.println("Not jolly");
                return;
            }
        }

        System.out.println("Jolly");
    }
}
