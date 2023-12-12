import java.util.*;

public class HappyNumber {
    public static void main(String[] args) {
      Solution202 solution = new Solution202();
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(1991));
    }
}

class Solution202{
    public boolean isHappy(int n){
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)){
            record.add(n);
            n = getNextNum(n);
        }
           return n == 1;
    }


    private ArrayList<Integer> getDigitalList(int a, ArrayList<Integer> list){

        while (a >= 10){
            list.add(a%10);
            a=a/10;
        }
        list.add(a);
        return list;

    }





    private int getNextNum( int n){
        int res = 0;
        while (n>0){
            int tem = n % 10;
            res += tem * tem;
            n = n/10;
        }
        return res;
    }
}
