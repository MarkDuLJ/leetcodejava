import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {0,1,1};
//        int[] nums = {0,0,0};
        Solution15 solution = new Solution15();
        System.out.println(solution.threeSumDPointers2(nums));
    }
}

class Solution15{
    public  List<List<Integer>> threeSumDPointers2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >0) return result;

//            remove duplicated element
            if(i>0 && nums[i] == nums[i-1]) continue;

            int left = i +1;
            int right = nums.length - 1;
            while (right > left){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                } else if (sum < 0) {
                    left++;
                }else {
                    result.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    while (right > left && nums[right] == nums[right-1]) right--;
                    while (right > left && nums[left] == nums[left+1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
    public  List<List<Integer>> threeSumDPointers(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int[] sorted= Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < sorted.length -2; i++) {
            int j = i+1;
            int k = sorted.length -1;
            while (j < k ){
            int sum = sorted[i] + sorted[j] +sorted[k];
                if(sum == 0){
                    result.add(List.of(sorted[i], sorted[j], sorted[k]));

                }
                if(sum > 0){
                    k--;
                }else {
                    j++;
                }
            }
        }
        List<List<Integer>> res = removeDuplicate(result);
        return res;
    }
    public  List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] +nums[k] == 0){
                        res.add(List.of(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
       List<List<Integer>> result = removeDuplicate(res);
        return result;
    }

    public List<List<Integer>> removeDuplicate(List<List<Integer>> list){
        Set<List<Integer>> unique = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> arr:
             list ) {
            List<Integer> sortedRow = new ArrayList<>(arr);
            Collections.sort(sortedRow);
            if(!unique.contains(sortedRow)){
                res.add(sortedRow);
                unique.add(sortedRow);
            }
        }
        return res;
    }
}

//class Solution18{
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//
//    }
//}

class ConcurrentDemo{
    public static void main(String[] args) throws InterruptedException {
//        LinkedList<String> link = new LinkedList<>(List.of("f", "b", "c", "d", "j"));
//        ArrayList<String> arr = new ArrayList<>(List.of("a", "g", "h", "i", "e"));
//
//        link.addLast(arr.set(arr.size() - 1, link.pollLast()));
//        link.addFirst(arr.set(0, link.pollFirst()));
//        System.out.println(link);
//        System.out.println(arr);
        ArrayList numbers = new ArrayList<>();
        Thread writer = new Thread(() -> addNumbers(numbers));
        writer.start();

        addNumbers(numbers);
        writer.join();

        System.out.println(numbers.size());
    }

    private  static void addNumbers(ArrayList<Integer> target){
        for (int i = 0; i < 100_000; i++) {
            target.add(i);
        }
        Map<Integer, String> characters = new HashMap<>();

        characters.put(1000, "Cinderella");
    }

}
