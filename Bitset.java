import java.util.BitSet;
import java.util.Scanner;

public class Bitset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        BitSet B1 = new BitSet(size);
        BitSet B2 = new BitSet(size);
        int orders = scanner.nextInt();
        while (orders-- >0 ){
            String op = scanner.next();
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            switch (op){
                case "AND":
                    if(first == 1 ){
                        B1.and(B2);
                    }
                    if(first == 2){
                        B2.and(B1);
                    }
                    break;

                case "SET":
                    if(first == 1){
                        B1.set(second);
                    }
                    if(first == 2){
                        B2.set(second);
                    }
                    break;

                case "FLIP":
                    if(first == 1){
                        B1.flip(second);
                    }
                    if(first == 2){
                        B2.flip(second);
                    }
                    break;

                case "OR":
                    if(first == 1){
                        B1.or(B2);
                    }
                    if(first == 2){
                        B2.or(B1);
                    }
                    break;

                case "XOR":
                    if(first == 1){
                        B1.xor(B2);
                    }
                    if(first == 2){
                        B2.xor(B1);
                    }
                    break;
            }
            System.out.println(B1.cardinality() +" " + B2.cardinality());
        }
    }
}
