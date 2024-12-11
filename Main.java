import SortedList.StackSort;


class Main {
    public static void main(String[] args) {
        StackSort<Integer> queue = new StackSort<>(5);

        queue.push(10);
        queue.push(20);
        queue.push(30);

        queue.push(-30);
        queue.print();

        queue.pop();
        queue.print();
    }
}