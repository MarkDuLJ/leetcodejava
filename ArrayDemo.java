import java.util.*;

public class ArrayDemo {
    public static void main(String[] args) {
      /*  int[] nums = {-4,-1,0,3,10};
        Solution977 solution = new Solution977();
        int[] result977 = solution.sortedSqares(nums);
        System.out.println(result977);
      */

        /*
        *
        int[] nums1 ={2,3,1,2,4,3};
        Solution209 solution209 = new Solution209();
        System.out.println(solution209.minSubArr(7,nums1));
        * */

        /*
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        Solution88 solution88 = new Solution88();
        solution88.merge(nums1,m,nums2,n);
        for (int el:
             nums1) {
            System.out.println(el);
        }
        * */

        Solution59 solution59 = new Solution59();
        System.out.println(solution59.generateMatrix(3));


    }
}


//input nums = [-4,-1,0,3,10]  sorted array
//square every element then sort
//output [0,1,9,16,100]
class Solution977{
    public  int[] sortedSqares(int[] nums){
        int[] result = new int[nums.length];
        int len = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                result[--len] = nums[left] * nums[left];
                left++;
            }else {
                result[--len] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}

class Solution209{
    public int minSubArr(int s, int[] nums){
        int min = Integer.MAX_VALUE;
        int start=0;
        int currentSum = 0;
        for (int end = 0; end <nums.length ; end++) {
            currentSum +=nums[end];
            while (currentSum >= s){
                min = Math.min(min, end-start +1);
                currentSum -= nums[start];
                start++;
            }
        }
        return min;

    }
}

/*You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
*
*/
class Solution88{
    public void merge(int[] nums1,int m, int[] nums2, int n){
        for (int j = 0, i=m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);

    }
}


/*
* Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
* */
class Solution59{
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int loop =0;
        int start =0;
        int num =1;
        int i,j;
        while (loop++ < n/2){
//            left to right
            for ( j = start; j < n-loop; j++) {
                result[start][j] = num++;
            }

//            up to down
            for(i=start;i<n-loop;i++){
                result[i][j] = num++;
            }

//            from right to left on bottom
            for(;j>=loop;j--){
                result[i][j] = num++;
            }

//            from down to up on left side
            for (;i>=loop;i--){
                result[i][j] = num++;
            }
            start++;

        }
        if(n%2 == 1){
            result[start][start]=num;
        }
        return result;
    }

}
