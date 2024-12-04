import java.util.Scanner;

public class Main {
    public static boolean execute = true;
    public static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        DinamicList<Integer> list = new DinamicList<>();
        list.PushBack(5);
        list.PushBack(2);
        list.PushBack(4);
        list.PushBack(5);

        list.print();
    }
/* 
    public static void main(String[] args) {

        /* read the length of the list 
        Queues<Integer> list = new Queues<Integer>(readSelection()[0]);

        do {
            int[] read = readSelection();
            if (read.length != 0)
            switch (read[0]) {
                case 1:
                    list.print();
                    break;
                case 2:
                    list.addLast(read[1]);
                    break;
                case 3:
                    list.removeLast();
                    break;
                
                case 4:
                    list.addFirst(read[1]);
                    break;

                case 5:
                    list.removeFirst();
                    break;

                default:
                    execute = false;
                    break;
            }
        }while(execute);
    }

    public static int[] readSelection() {
        try{
           String[] options = Main.input.nextLine().split(" "); 
           int[] toReturn = new int[options.length];

            for(int i = 0; i < options.length; i++) {
                toReturn[i] = Integer.parseInt(options[i]);
            }
            return toReturn;
        }catch(RuntimeException e) {
            Main.execute = false;
        }
        
        return new int[0];
    }
*/
}