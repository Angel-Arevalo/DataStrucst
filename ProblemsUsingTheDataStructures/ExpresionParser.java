package ProblemsUsingTheDataStructures;

import DinamicList.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ExpresionParser {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        Stack<String> results = new Stack<>();
        Stack<String> operations = new Stack<>();

        String[] s = bufferedReader.readLine().split(" ");

        for(int i = s.length - 1; 0<= i; i--) {
            String w = s[i];

            if(isOperador(w)) {
                String o1 = operations.ptp();
                String o2 = operations.ptp();

                operations.push("(" + o1 + " " + w + " " + o2 + ")");
                int n = Integer.parseInt(results.ptp());
                int m = Integer.parseInt(results.ptp());

                results.push(doOperation(w, n, m));
            }else {
                operations.push(w);
                results.push(w);
            }
        }
        System.out.println(operations.ptp() + " = " + results.ptp());
        bufferedReader.close();
    }

    public static Boolean isOperador(String toSee) {
        return "+-*/".contains(toSee);
    }

    public static String doOperation(String operation, int m, int n) {
        char op = operation.charAt(0);

        switch (op) {
            case '+':
                return String.valueOf(m+n);

            case '-':
                return String.valueOf(m - n);
                
            
            case '*':
                return String.valueOf(n*m);

            case '/':
                return String.valueOf(m/n);
            default:
                return "";
        }
    }
}
