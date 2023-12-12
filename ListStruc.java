import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ListStruc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list= new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int qOfNum = scanner.nextInt();
        while (qOfNum-- > 0){
            String command = scanner.next();
            switch (command){
                case "Insert":
                    int index = scanner.nextInt();
                    int val = scanner.nextInt();
                    if(index < list.size()){
                        list.add(index,val);
                    }
                    break;

                case "Delete":
                    int indexDel = scanner.nextInt();
                    list.remove(indexDel);
                    break;
            }
        }
        String str = list.toString().replace(", " ," ");
        String res = str.replaceAll("\\[|\\]","");
        System.out.println(res);
        scanner.close();
    }
}

 class  StackSample{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> res = new ArrayList<>();
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            int len = str.length();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                
            }

        }
             scanner.close();

        for (String str :
                res) {
            System.out.println(str);
        }

    }

}
