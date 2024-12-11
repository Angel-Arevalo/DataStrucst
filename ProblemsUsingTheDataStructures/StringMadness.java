package ProblemsUsingTheDataStructures;

import ReadSelection.ReadSelection;
import StaticList.ListTest;

public class StringMadness {
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
            list.set(f - 1, null);
            list.set(last - 1, newString);
        }while(true);

        if(last != -1)System.out.println(list.getIndex(last - 1));
    }
}
