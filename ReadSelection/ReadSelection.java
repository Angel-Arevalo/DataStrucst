package ReadSelection;
import java.util.Scanner;
import StaticList.ListTest;

public class ReadSelection {
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
