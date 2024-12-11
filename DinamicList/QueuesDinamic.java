package DinamicList;

import StaticList.Queues;

public class QueuesDinamic<T> {
    private Queues<T> list;

    public QueuesDinamic(int length) {
        list = new Queues<>(length);
    }

    public QueuesDinamic() {
        list = new Queues<T>(10);
    }

    public void addLast(T newItem) {
        try {
            list.addLast(newItem);
        }catch(RuntimeException e) {
            Queues<T> newQueue = new Queues<T>(list.getLength()*2);
            newQueue.copy(list);
            list = newQueue;
            list.addLast(newItem);
            
        }
    }

    public void addFirst(T newItem) {
        try {
            list.addFirst(newItem);
        }catch(RuntimeException e) {
            Queues<T> newQueue = new Queues<>(list.getLength()*2);
            newQueue.copy(list);
            list = newQueue;
            list.addFirst(newItem);
        }
    }

    public void removeLast() {
        list.removeLast();
    }

    public void removeFirst() {
        list.removeFirst();
    }

    public void print() {
        list.print();
    }

    public int size() {
        return list.getCounter();
    }
}
