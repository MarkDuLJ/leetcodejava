import java.lang.management.MemoryType;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {
    public static void main(String[] args) {
        String regex = "\\b(\\w+)(\\s+\\1\\b)+";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- >0){
            String str = scanner.nextLine();
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()){
                str = str.replaceAll(matcher.group(0), matcher.group(1));
            }
            System.out.println(str);
        }
        scanner.close();
    }
}
