import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        ArrayList<String> output = new ArrayList<>();
        Queue<String> stack = new LinkedList<>();

/*        lettle by letter
        while (num-- >0){
            String str = scanner.nextLine();
            char[] charArr = str.toCharArray();
            int len = charArr.length;
            int i = 0;
            while (i<len) {
                if (charArr[i] == '<') {
                    if (i + 1 < len && charArr[i + 1] == '/') {
                        i++;
                    }
                    i++;
                    String tem = "";
                    while (charArr[i] != '>') {
                        tem += charArr[i];
                        i++;
                    }
                    stack.offer(tem);
                }

                if(charArr[i] == '>'){
                    if(i + 1 < len && charArr[i+1] == '<'){
                        if (charArr[i] == '<') {
                            if (i + 1 < len && charArr[i + 1] == '/') {
                                i++;
                            }
                            i++;
                            String tem = "";
                            while (charArr[i] != '>') {
                                tem += charArr[i];
                                i++;
                            }
                            stack.offer(tem);
                        }
                    }
                    if(i+1 < len && charArr[i+1] != '<'){
                        i++;
                        String tem = "";
                        while ( i<len && charArr[i] != '<'){
                            tem += charArr[i];
                            ++i;
                        }
                        output.add(tem);
                        i--;
                    }
                }

                i++;
            }

            boolean match = true;
            while (!stack.isEmpty()){
                String val1 = stack.poll();
                String val2 = stack.poll();
                if(!val2.equals(val1)) {
                    match = false;
                }
            }
            if(stack.isEmpty() && match){
                for (String s :
                        output) {
                    System.out.println(s);
                }
            }else {
                System.out.println("None");
                stack.clear();
            }
                output.clear();
        }
*/

//        Regex
        boolean tagMatch = false;
        while (num-- > 0){
            String str = scanner.nextLine();
            String regex = "<([^<>]+)>([^<>]+)<\\/\\1>";
            Pattern pattern = Pattern.compile(regex);

            Matcher match = pattern.matcher(str);

            while (match.find()) {

                String validStr = match.group(2);
                System.out.println(validStr);
                tagMatch = true;
            }

            if(!tagMatch){
                System.out.println("None");
            }

        }
        scanner.close();
    }
}
