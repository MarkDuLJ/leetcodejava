import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class SubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        int[] nums = Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        System.out.println(calArr(nums));
    }

    public static int calArr(int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int res = arr[i];
            if(res < 0) count++ ;
            for (int j = i+1; j <arr.length ; j++) {
                res += arr[j];
                if(res < 0) count++;
            }
        }
        return count;
    }

}
