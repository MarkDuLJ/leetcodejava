import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VailidName {
    public static void main(String[] args) {
        String regex = "^[A-Za-z]\\w{7,29}";
        Pattern pattern = Pattern.compile(regex);

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- >0){
            String str = scanner.nextLine();
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()){
                System.out.println("Valid");
            }else {
                System.out.println("Invalid");
            }
        }
        scanner.close();
        Collection<String> collection = new ArrayList<>();

    }
}

class ValidParentheses{
    public static void main(String[] args) {
//        String str ="({[]})";
//        String str ="()}";
//        String str ="(){}";

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();

            Stack<Character> stack = new Stack<>();
            for (char ch :
                    str.toCharArray()) {
                if(!stack.isEmpty() &&(
                        (stack.peek()=='(' && ch == ')')||
                        (stack.peek()=='{' && ch == '}')||
                        (stack.peek()=='[' && ch == ']'))
                ){
                    stack.pop();
                }else {
                    stack.push(ch);
                }
            }

            if (stack.isEmpty()) {
                System.out.println("true");
            }else {
                System.out.println("false");
            }
        }
    }
}
