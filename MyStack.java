import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public  char peekN(int n){
        return stackArr[n];
    }
    public  int size(){
        return top+1;
    }

    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top == maxSize-1;
    }
    public void displayStack(String s){
        System.out.println(s);
        System.out.println("Stack (bottom-->top: ");
        for (int i = 0; i < size(); i++) {
            System.out.println(peekN(i));
            System.out.println(' ');
        }
        System.out.println(" ");
    }
}

class IntoPost{
    private MyStack stack;
    private String input;
    private String output="";

    public IntoPost(String in) {
        input = in;
        int stackSize = input.length();
        stack = new MyStack(stackSize);
    }

    public String doTrans(){
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.displayStack("For "+ch+" ");
            switch (ch){
                case '+':
                case '-':
                    gotOper(ch,1);
                    break;

                case '*':
                case '/':
                    gotOper(ch,2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!stack.isEmpty()){
            stack.displayStack("While");
            output = output + stack.pop();
        }
        stack.displayStack("End ");
        return output;
    }

    public void gotOper(char opThis, int prec1){
        while (!stack.isEmpty()){
            char opTop = stack.pop();
            if(opTop == '('){
                stack.push(opTop);
                break;
            }else {
                int prec2;
                if(opTop == '+' || opTop == '-'){
                    prec2 = 1;
                }else {prec2 =2;}

                if(prec2<prec1){
                    stack.push(opTop);
                    break;
                }else {
                    output = output+opTop;
                }
            }
        }
        stack.push(opThis);
    }

    class InfixApp{
        public static void main(String[] args) throws IOException {
            String input,output;
            while (true){
                System.out.println("Enter infix: ");
                System.out.flush();
                input = getString();
                if(input.equals("")) break;

                IntoPost trans = new IntoPost(input);
                output = trans.doTrans();
                System.out.println("PostFix is "+output+'\n');
            }
        }

        public static String getString() throws IOException {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            return s;
        }
    }

    public void gotParen(char ch){
        while (!stack.isEmpty()){
            char chx = stack.pop();
            if(chx == '('){break;}else {
                output = output + chx;
            }
        }
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
