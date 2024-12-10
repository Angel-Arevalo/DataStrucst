package ProblemsUsingTheDataStructures;

import ReadSelection.ReadSelection;
import DinamicList.Stack;

public class BracketsProblem {
    private static ReadSelection reader = new ReadSelection();
    private static Stack<Character> stack = new Stack<Character>();
    private static Boolean isFar = true;

    public static void main(String[] args) {
        reader.readInt();
        char[] line = reader.readLine().toCharArray();
        
        for(int i = 0; i < line.length; i++) {
            char caracter = line[i];
            if(caracter == ' ');
            else if(caracter == '(' || caracter == '{' || caracter == '[') stack.push(caracter);
            else {
                if(stack.isEmpty()) {
                    System.out.println(caracter + " " + i);
                    i = line.length;
                    isFar = false;
                }
                else if(  caracter == ')' && stack.top() == '('
                ||   caracter == '}' && stack.top() == '{'
                ||   caracter == ']' && stack.top() == '[') stack.pop();
                else {
                    System.out.println(caracter + " " + i);
                    i = line.length;
                    isFar = false;
                }
            }
        }

        if(isFar) System.out.println("ok so far");
    }
}
