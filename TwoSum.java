import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,11,8,15,1,2,7};
//        int[] nums = {11,8,15,1,2,7};
        int target = 9;
        Solution1 solution = new Solution1();
        int[] res = solution.twoSum4(nums,target);
        for (int e :
                res) {

        System.out.println("hello" + e);
        }
    }
}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i<nums.length; i++){
            for (int j =0; j<nums.length; j++){
                if(j != i ){
                    int val1 = nums[i];
                    int val2 = nums[j];
                    if(target == val1 + val2){
                        res[0] = i;
                        res[1] = j;
                        return res;
                    }
                }
            }


        }
        return res;
    }

    public  int[] twoSum2(int[] nums, int target){
        int[] res = new int[2];
        int len = nums.length;
        int i = 0;
        while (i<len){
            if(nums[i] < target){
                int j = i + 1;
                while (j < len){
                    if(nums[j] < target){
                        if(target == nums[i] + nums[j]){
                            res[0] = i;
                            res[1] = j;
                            return res;
                        }else {
                            j++;
                        }
                    }
                    j++;
                }
            }
                    i++;
        }

        return res;
    }

//    use map
    public  int[] twoSum3(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < target){
                if(map.containsKey(nums[i])){
                    return new int[]{ map.get(nums[i]),i};
                }else {
                    map.put(target-nums[i], i);
                }
            }

        }
        System.out.println(map);

        return new int[]{0,0};
    }

//    use set
    public  int[] twoSum4(int[] nums, int target){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < target){
                if(set.contains(nums[i])){
                    System.out.println(set);
                }
                set.add(target-nums[i]);
            }
        }

        return new int[]{0,0};
    }
}