package SortedList;

public interface SortedList<Type> {

    public Boolean empty();
    public int size();
    public void insert(Type element);
    public void remove(Type element);
    public int find(Type element);
    public void print();
}
