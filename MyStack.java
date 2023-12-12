import java.util.Stack;

public class MyStack {
    private int maxSize;
    private char[] stackArr;
    private int top;
    public MyStack(int s){
        maxSize = s;
        stackArr = new char[maxSize];
        top = -1;
    }

    public void push(char j){
        stackArr[++top]=j;
    }


    public char pop() {
        return stackArr[top--];
    }

    public  char peek(){
        return stackArr[top];
    }

    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top == maxSize-1;
    }
}
class Reverser{
    private String input;
    private String output;

    public Reverser(String in){
        input = in;
    }

    public String doRev(){
        int stackSize = input.length();
        MyStack stack = new MyStack(stackSize);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);
        }

        output = "";
        while (!stack.isEmpty()){
            char ch = stack.pop();
            output +=ch;
        }
        return output;
    }
}
