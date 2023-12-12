public class MyPriorityQ {
    private int maxSize;
    private long[] queArr;
    private int nItems;
    public MyPriorityQ(int s){
        maxSize=s;
        queArr = new long[maxSize];// ordered array max at index 0
        nItems = 0;
    }

    public void insert(long item){
        int j;
        if(nItems == 0) {
            queArr[nItems++] = item;
        }else {
            for (j=nItems-1; j>=0; j--){
                if(item > queArr[j]){
                    queArr[j+1] = queArr[j];
                }else {
                    break;
                }
            }
            queArr[j+1] =item;
            nItems++;
        }
    }

    public long remove(){
        return queArr[--nItems];
    }

    public long peekMin(){
        return queArr[nItems-1];
    }

    public boolean isEmpty(){
        return nItems == 0;
    }

    public boolean isFull(){
        return nItems == maxSize;
    }
}

class MyPQApp{
    public static void main(String[] args) {
        MyPriorityQ priorityQ = new MyPriorityQ(5);
        priorityQ.insert(30);
        priorityQ.insert(50);
        priorityQ.insert(10);
        priorityQ.insert(40);
        priorityQ.insert(20);
    }
}
