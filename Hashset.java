import java.util.*;
import java.util.function.Function;

public class Hashset {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int size = scanner.nextInt();
        int max = 0;
        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            int el = scanner.nextInt();
            deque.add(el);
            }

        int cur = (int) deque.stream().distinct().count();
        if(cur > max) max = cur;
        for (int j = size; j < n; j++) {
            if(max == size) {
                System.out.println(max);
                return;
            }

            int el = scanner.nextInt();
            int old = deque.removeFirst();
            if(!deque.contains(old) ){
                cur--;
            }
            if(!deque.contains(el)){
                cur++;
            }
            deque.add(el);
            if(cur > max) max = cur;
        }
        System.out.println(max);

        }

}

class Player{
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return this.getName() +" "+ this.getScore();
    }
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        int scoreComparison = Integer.compare(o2.getScore(),o1.getScore());

        if(scoreComparison == 0){
            return o1.getName().compareTo((o2.getName()));
        }

        return scoreComparison;
    }

}

class Student{
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
