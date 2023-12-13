import java.util.List;

public class FirstLastApp {
    public static void main(String[] args) {
        FistLastList list = new FistLastList();
        list.insertFirst(22);
        list.insertFirst(44);
        list.insertFirst(66);

        list.insertLast(11);
        list.insertLast(33);
        list.insertLast(55);

        list.displayList();

        list.delFirst();
        list.delFirst();

        list.displayList();
    }
}

class SortedList{
    private Link first;
    public SortedList(){
        first = null;
    }

    public SortedList(Link[] linkArr){
        first = null;
        for (int j = 0; j < linkArr.length; j++) {
            insert(linkArr[j]);
        }
    }

    public void insert(Link k){
        Link previous=null;
        Link current = first;
        while (current!= null && k.dData > current.dData){
            previous = current;
            current = current.next;
        }
        if(previous == null){
            first = k;
        }else {
            previous.next = k;
        }
        k.next = current;
    }

    public Link remove(){
        Link temp = first;
        first = first.next;
        return temp;
    }
}
class FistLastList{
    private Link first;
    private Link last;

    public FistLastList() {
        first = null;
        last = null;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public void insertFirst(long dd){
        Link newLink = new Link(dd);
        if(isEmpty()){
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long dd){
        Link newLink = new Link(dd);
        if(isEmpty()){
            first = newLink;
        }else {
            last.next=newLink;
        }
        last = newLink;
    }

    public long delFirst(){
        long temp = first.dData;
        if(first.next == null){
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayList(){
        System.out.println("List (first-->last): ");
        Link current = first;
        while (current!= null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class Link{
    public long dData;
    public Link next;

    public Link(long d) {
        dData = d;
    }

    public void displayLink(){
        System.out.println(dData + " ");
    }


}
