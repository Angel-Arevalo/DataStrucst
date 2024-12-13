package ProblemsUsingTheDataStructures;

import java.util.Scanner;

public class JollyProblem {
    private static Scanner reader = new Scanner(System.in);
    private static int[] values;
    private static boolean execute = true;

    public static void main(String[] args) {
        do {
            values = read();
            if(values.length == 0) execute = false;
            else {
                jolly();
            }
        } while(execute);
    }

    // read the values of the line of the input
    private static int[] read() {
        String[] line = reader.nextLine().split(" ");
        int size = Integer.parseInt(line[0]);

        int[] val = new int[size];

        for(int i = 1, j = 0; i <= size; i++, j++) {
            val[j] = Integer.parseInt(line[i]);
        }

        return val;
    }

    private static void jolly() {
        int length = values.length;

        if(length == 1) {
            System.out.println("Jolly");
            return;
        }else if(length == 2) {
            if(Math.abs(values[0] - values[1]) == 1) {
                System.out.println("Jolly");
            }else System.out.println("Not jolly");

            return;
        }

        Boolean[] vol = new Boolean[length - 1];

        for(int i = 0; i < length - 1; i++) {
            int absVal = Math.abs(values[i] - values[i+1]);

            if(absVal == 0 || length - 1 < absVal || vol[absVal - 1]) {
                System.out.println("Not jolly");
                return;
            }
            vol[absVal - 1] = true;
        }

        for(Boolean c: vol) {
            if(!c) {
                System.out.println("Not jolly");
                return;
            }
        }

        System.out.println("Jolly");
    }
}
