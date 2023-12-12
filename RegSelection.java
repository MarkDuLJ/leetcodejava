import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegSelection {
    public static void main(String[] args) {
        String regex= "\\b(\\w+)\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Scanner scanner = new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        String[] list = new String[n];
        for (int i=0;i<n;i++){
            String str = scanner.nextLine();
            Matcher m = pattern.matcher(str);
            while (m.find()){
                list[i]=str.replaceAll(m.group(0), m.group(1));
            }
        }

        for (String e :
                list) {
            System.out.println(e);
        }
    }
}


