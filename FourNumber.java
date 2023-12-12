import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FourNumber {
    public static void main(String[] args) {
        Solution454 solution = new Solution454();
        int[] num1 = new int[]{1,2};
        int[] num2 = new int[]{-2,-1};
        int[] num3 = new int[]{-1,2};
        int[] num4 = new int[]{0,2};
        int nums = solution.fourSumCount(num1,num2,num3,num4);
        int numsA = solution.fourSumCount(new int[]{0},new int[]{0},new int[]{0},new int[]{0});

        int numsHash = solution.fourSumCountHash(num1,num2,num3,num4);
        int numsAHash = solution.fourSumCountHash(new int[]{0},new int[]{0},new int[]{0},new int[]{0});

        int numsMap = solution.fourSumCountMap(num1,num2,num3,num4);
        int numsAmap = solution.fourSumCountMap(new int[]{0},new int[]{0},new int[]{0},new int[]{0});

        System.out.println(nums);
        System.out.println(numsA);

        System.out.println(numsHash);
        System.out.println(numsAHash);

        System.out.println(numsMap);
        System.out.println(numsAmap);
    }
}

class Solution454{
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int res1 = nums1[i];
            for (int j = 0; j < n; j++) {
                int res2 = nums2[j];
                for (int k = 0; k < n; k++) {
                    int res3 = nums3[k];
                    for (int l = 0; l < n; l++) {
                        int res = nums4[l] + res3 +res2 + res1;
                        if(res == 0){
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public int fourSumCountHash(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;

        Map<Integer,Integer> map =new HashMap<>();
        for (int i :
                nums1) {
            for (int j:
                 nums2) {
                int sum = i + j;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }

        for (int i :
                nums3) {
            for (int j:
                 nums4) {
                int res = 0 - i -j;
                if(map.containsKey(res)){
                    count ++;
                }
            }
        }

        return count;
    }

    public int fourSumCountMap(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        double size =Math.pow(nums1.length,4);
        Map<Integer, Integer> map = new HashMap<>();
        return 0;
    }
}
