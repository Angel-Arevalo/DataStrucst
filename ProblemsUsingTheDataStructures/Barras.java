package ProblemsUsingTheDataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Barras {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Boolean execute = true;
        int aMax = 0;
        while(execute) {
            String[] options = readSelections();
            int times = Integer.parseInt(options[0]);

            if(times != 0) {
                for(int i = 1; i < options.length; i++) {
                    int heigth = Integer.parseInt(options[i]);
                    for(int j = heigth; 1 <= j; j--) {
                        int base = 1;
                        for(int l = i + 1; l < options.length; l++) {
                            if(j <= Integer.parseInt(options[l])) base++;
                            else break;
                        }
                        if(aMax < j*base) aMax = j*base;
                    }
                }

                System.out.println(aMax);
            }else execute = false; 
        }
    }

    public static String[] readSelections() throws IOException {
        return reader.readLine().split(" ");
    }
}