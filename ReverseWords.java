import java.util.StringTokenizer;

public class ReverseWords {
    public static void main(String[] args) {
        Solution151 res = new Solution151();
        System.out.printf("empty input: %s \n",res.reverse(""));
        System.out.printf("whitespaces before input:%s\n",res.reverse("      abc   "));
        System.out.printf("whitespaces among input:%s\n",res.reverse("      abc de   fgh  "));
        System.out.printf("whitespaces among input:%s\n",res.reverseDoublePointer("      abc de   fgh  "));
        System.out.printf("whitespaces among input:%s\n",res.reverseSplit("      abc de   fgh  "));


    }
}


class Solution151{
    public String reverse(String s){
        int i = s.length()-1;
        StringBuilder res = new StringBuilder();
        while (i>=0){
            while (i>=0 && s.charAt(i) == ' ') i--;
            int j=i;
            while (i>=0 && s.charAt(i) != ' ') i--;
            if(res.isEmpty()){
                res.append(s.substring(i+1,j+1));
            }else {
                res.append(" ").append(s.substring(i + 1, j + 1));
            }

        }
//        "  hello world  " will fail because of one white space at the end.
        return res.toString();
    }
    public String reverseDoublePointer(String s){
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    public String reverseSplit(String s){
        String[] str = s.trim().split("\\s+");
        String res ="";
        for(int i = str.length-1; i>0; i--){
            res += str[i] + " ";
        }
        return res + str[0];
    }

}

interface Resizable {

    void resize(float scale);

}

abstract class GraphicObject {
    int xPos, yPos;

    abstract void draw();
}


