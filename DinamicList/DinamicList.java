package DinamicList;
import ListError.*;
import StaticList.ListTest;

class DinamicList<T> {
    private ListTest<T> list = new ListTest<T>(2);

    public void PushBack(T newItem) {
        try {
            list.PushBack(newItem);
        }catch(FullError e) {
            ListTest<T> newList = new ListTest<T>(list.getLength()*2);
            newList.copyList(list);
            list = newList;
            list.PushBack(newItem);
        }
    }

    public void PopBack() {
        list.PopBack();
    }

    public void print() {
        System.out.println(toString());
    }

    public String toString() {
        return list.toString();
    }
}
