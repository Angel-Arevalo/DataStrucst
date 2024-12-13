package ProblemsUsingTheDataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class JoinStrings {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        String[] strings = new String[length];
        int lastIndex = 0;

        for (int i = 0; i < length; i++) {
            strings[i] = reader.readLine();
        }

        ArrayList<Integer>[] list = new ArrayList[length];

        for(int i = 0; i < length; i++) {
            list[i] = (new ArrayList<>());
        }

        for (int i = 0; i < length - 1; i++) {
            String[] options = reader.readLine().split(" ");
            int o1 = Integer.parseInt(options[0]);
            int o2 = Integer.parseInt(options[1]);
            list[o1 - 1].add(o2 - 1);
            lastIndex = o1 - 1;
        }

        print(list, strings, lastIndex);
        writer.flush();
    }

    private static void print(ArrayList<Integer>[] matrix, String[] words, int index) throws IOException{
        writer.write(words[index]);
       

        for(int newIndex: matrix[index]) {
            print(matrix, words, newIndex);
        }
    }
}
