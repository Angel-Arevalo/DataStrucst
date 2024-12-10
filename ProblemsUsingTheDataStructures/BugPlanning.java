package ProblemsUsingTheDataStructures;

import DinamicList.DinamicList;
import StaticList.ListTest;
import ReadSelection.ReadSelection;


public class BugPlanning {
    private static DinamicList<Integer> list = new DinamicList<Integer>();
    private static ReadSelection reader = new ReadSelection();

    public static void main(String[] args) {
        reader.readInt();
        ListTest<Integer> courses = reader.readSelections();

        int g = courses.getIndex(0);
        list.PushBack(g);
        for(int i = 0; i < courses.getLength(); i++) {
            if(g < courses.getIndex(i)) {
                g = courses.getIndex(i);
                list.PushBack(g);
            }
        }

        int size = list.size();
        System.out.println(size);
        
        for(int i = 0; i < size; i++) {
            System.out.print(list.get(i) + ((i < size - 1)? " ": ""));
        }
    }
}
