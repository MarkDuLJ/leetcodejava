public class MyQueue {
    private  int maxSize;
    private long[] queArr;
    private int front;
    private int rear;


    public MyQueue(int s) {
        maxSize = s+1;
        queArr = new long[maxSize];
        front = 0;
        rear = -1;
    }

    public void insert(long j){
        if(rear == maxSize - 1){
            rear = -1;
        }
        queArr[++rear] = j;

    }

    public long remove(){
        long temp = queArr[front++];
        if(front == maxSize){
            front = 0;
        }
        return temp;
    }

    public long peekFront(){
        return  queArr[front];
    }

    public boolean isEmpty(){
        return rear+1 == front || front+maxSize-1 == rear;
    }

    public boolean isFull(){
        return rear+2 == front || front+maxSize-2 == rear;
    }

    public int size(){
        if(rear >= front) {
            return rear-front+1;
        }else {
            return maxSize -front +rear+1;
        }

    }
}

class QueApp{
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);

        queue.remove();
        queue.remove();
        queue.remove();


        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.insert(80);
//        queue.insert(90);


        while (!queue.isEmpty()){
            long n = queue.remove();
            System.out.println(n);
        }
    }

}
