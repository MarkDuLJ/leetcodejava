public class StringDemo {
    public static void main(String[] args) {
        String str = "hello world";
        Solution344 solution344= new Solution344();
        Solution541 solution541= new Solution541();
//        solution344.reverseString(str.toCharArray());
        System.out.println(solution541.reverseStr(str,3));
    }
}

class Solution344{
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length -1;
        while (left<right){
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }
}

class Solution541{
    Solution344 solution344= new Solution344();
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i <ch.length ; i += 2*k) {
            int start = i;
            int end = Math.min(ch.length-1,start + k - 1);
            while (start < end){
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }


}
