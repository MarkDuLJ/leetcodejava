import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class twoDHourGlass {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();


        System.out.println(arr.toString());
        int row = arr.size();
        int col = arr.get(0).size();
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < row -3 +1; i++) {
            for (int j = 0; j < col -3 +1; j++) {
                int[][] hourglass = new int[3][3];
                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        hourglass[a][b] = arr.get(i+a).get(j+b);
                    }
                }
               res =  getHourglassSum(hourglass) > res ? getHourglassSum(hourglass) : res;

            }
        }

        System.out.println(res);

    }

    public static int getHourglassSum(int[][] arr){
        int res = 0;
        res = res + arr[0][0] + arr[0][1] + arr[0][2] + arr[1][1] + arr[2][0] + arr[2][1] + arr[2][2] ;
        return res;
    }


}

class twoDArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            String input = scanner.nextLine();
            int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            if(nums.length > 1){
                for (int j = 1; j < nums[0]+1; j++) {
                    row.add(nums[j]);
                }
            }
            list.add(row);
        }


        int qOfNum =Integer.parseInt(scanner.nextLine());
        ArrayList<String> answers = new ArrayList<>();
        for (int i = 0; i <qOfNum; i++) {
            String string = scanner.nextLine();
            int[] positions = Arrays.stream(string.split(" ")).mapToInt(Integer::parseInt).toArray();
            try {
               int result = list.get(positions[0]-1).get(positions[1]-1);
               answers.add(result + "");
            }catch (Exception ex){
//                System.out.println("get list positions error.");
                answers.add("ERROR!");
            }
        }
        for (String s :
                answers) {
            System.out.println(s);
        }
    }
}


 class LeapGame {

//    use list to store the possible path, mark already tired point to 1 which means is occupied.
    public static boolean canWinQueue(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
      int i = 0;
        Queue<Integer> list  = new LinkedList<>();
        list.add(leap);
        list.add(i+1);
        while (!list.isEmpty()){
            int next = list.poll();
            if(next > game.length -1) return true;
            if(game[next] == 0 ){
                i = next;
                if (i != 0) {
                    list.add(i-1);
                    list.add(i+leap);
                    list.add(i+1);
                    game[i] = 1;
                }
            }
        }

        return false;
    }

//    recursive
     public static boolean canWin(int leap, int[] game) {
        return canWin(leap,game,0);
     }
     private static boolean canWin(int leap, int[] game, int i){
        game[i] = 1;
        if(i+1 >game.length || i + leap >= game.length) {
            return  true;
        } else if (game[i+1] == 1 && game[i + leap] == 1 && i > 0 && game[i-1] == 1) {
            return false;
        }else {
            return (game[i+1] == 0 && canWin(leap,game,i+1)) ||
                    (game[i+leap] == 0 && canWin(leap,game,i+leap)) ||
                    (i>0 && game[i-1] == 0 && canWin(leap,game,i-1));
        }

     }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}