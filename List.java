interface List {

    public void pushFront(int key);
    public void pushBack(int key);
    public void popFront();
    public void popFinal();
    public void print(); 
}

interface ListTail extends List {

    public void addBefore(int key);
    public void addAfter(int key);
}