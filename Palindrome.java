import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Palindrome {
    public static void main(String[] args) {
        String s ="mqmadamqm";
        String x ="yessir";
        String a ="Hello,, thanks for attempting this problem! Hope it will help you to learn java! Good luck and have a nice day!";
        System.out.println(Solution125.isPalindromeRecur(s));
        System.out.println(Solution125.isPalindromeRecur(x));
        System.out.println(Solution125.tokens(a));
        System.out.println(Solution125.tokens(",,"));
    }
}

class Solution125 {
    public static boolean isPalindrome(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i)==s.charAt(s.length()-i-1)){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRecur(String s){
        if(s.length()<2) return true;
        if(s.charAt(0) != s.charAt(s.length()-1)){
            return false;
        }else {
            s= s.substring(1,s.length()-1);
            return isPalindrome(s);
        }
    }

    public static String[] tokens(String s){
        s=s.trim();
        if (s.isEmpty()|| s == null) {
            System.out.println(0);
            return null;
        }
        String[] tokens = s.split("[^a-zA-Z]+");
//        String[] tokens = s.trim().split("[!,?.*_'@\\ ]+");
//        String[] tokens = s.split("[\s+ !,?._'@]");
//        s= s.replaceAll("[^a-z A-Z]", " ");
//        s= s.replaceAll("\\s+", " ");
//        String[] tokens = s.trim().split(" ");

        System.out.println(tokens.length);
        for (String c :
                tokens) {
            System.out.println(c);
        }
        return tokens;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        MyRegex reg= new MyRegex();

        String regex = reg.pattern;

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            try{
                Pattern pattern = Pattern.compile(regex);

                Matcher m = pattern.matcher(line);
                if(m.matches()){
                    System.out.println("true");
                }else {
                    System.out.println("false");
                }
            } catch (PatternSyntaxException ex){
                System.out.println("false");
            }
        }



    }

    static class MyRegex {
        String pattern = "^(((\\d|0\\d|00\\d|\\d{2}|0\\d{2}|1\\d{2}|2[0-4]\\d|2[0-5]{2})\\.){3})(\\d|0\\d|00\\d|\\d{2}|0\\d{2}|1\\d{2}|2[0-4]\\d|2[0-5]{2})$";
    }
}
