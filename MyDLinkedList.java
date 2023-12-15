public class MyDLinkedList {
    public static void main(String[] args) {
        DLinkList list = new DLinkList();
        list.insertFirst(22);
        list.insertFirst(44);
        list.insertFirst(66);

        list.insertLast(11);
        list.insertLast(33);
        list.insertLast(55);


    }
}

class DLink{
    public long dData;
    public DLink next;
    public DLink previous;

    public DLink(long d) {
        dData = d;
    }

}
class DLinkList{
    private DLink first;
    private DLink last;

    public DLinkList() {
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(long dd){
        DLink newLink = new DLink(dd);
        if(isEmpty()){
            last = newLink;
        }else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long dd){
        DLink newLink = new DLink(dd);
        if(isEmpty()){
            first = newLink;
        }else {
            last.next = newLink;
            newLink.previous = last;
        }
        last= newLink;
    }

    public  DLink deleteFirst(){
        DLink temp = first;
        if(first.next == null){
            last = null;
        }else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    public DLink deleteLast(){
        DLink temp = last;
        if(first.next == null){
            first = null;
        }else {
            last.previous.next=null;
        }
        last = last.previous;
        return temp;
    }

    public boolean insertAfter(long key, long dd){//insert dd after key
        DLink current = first;
        while (current.dData != key) {//assume non-empty list
            current = current.next;
            if (current == null) return false;
        }
            DLink newLink = new DLink(dd);
            if (current == last) {
                newLink.next = null;
                last = newLink;
            } else {
                newLink.next = current.next;
                current.next.previous = newLink;
            }

            newLink.previous = current;
            current.next = newLink;
            return true;
        }

        public  DLink deleteKey(long key){
         DLink current  = first;
         while (current.dData != key){
             current = current.next;
             if(current == null){
                 return null;
             }
         }
         if(current == first){
             first = current.next;
         }else {
             current.previous.next = current.next;
         }

         if(current == last){
             last = current.previous;
         }else {
             current.next.previous = current.previous;
         }
         return current;
        }


}
