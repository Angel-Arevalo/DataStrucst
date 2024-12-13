package ProblemsUsingTheDataStructures;

import java.util.Scanner;

public class BugPlanning {
    private static Scanner reader = new Scanner(System.in);

    private static int[] readSelections() {
        String[] line = reader.nextLine().split(" ");
        int[] val = new int[line.length];

        for(int i = 0; i < val.length; i++) {
            val[i] = Integer.parseInt(line[i]);
        }

        return val;
    }

    public static void main(String[] args) {
        int length = readSelections()[0];
        int newLength = 1;
        int[] values = readSelections();
        int[] finalInts = new int[length];

        int g = values[0];
        finalInts[0] = g;

        for(int i = 1, j = 1; i < length; i++) {
            if(g < values[i]) {
                finalInts[j] = values[i];
                j++;
                newLength++;
                g = values[i];
            }
        }

        System.out.println(newLength);
        for(int c = 0; c < newLength; c++) {
            System.out.print(finalInts[c] + " ");
        }
    }
}
