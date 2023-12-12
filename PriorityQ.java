import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> events =new ArrayList<>();
        Priorities priorities =new Priorities();

        int ops = Integer.parseInt(scanner.nextLine());
        while (ops-- >0){
            String cmd = scanner.nextLine();
            events.add(cmd);
        }
        scanner.close();

        List<StudentSimple> res = priorities.getStudents(events);
        if(res.size() == 0) {
            System.out.println("EMPTY");
        }else {
            for (StudentSimple s :
                    res) {
                System.out.println(s.getName());
            }
        }
    }
}


class StudentSimple implements Comparable<StudentSimple>{
    private int id;
    private String name;
    private double cgpa;

    public StudentSimple(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    @Override
    public int compareTo(StudentSimple o) {
        int gpaComparison = Double.compare(o.getCGPA(), this.cgpa);
        if(gpaComparison != 0) return gpaComparison;

        int nameComparison = this.name.compareTo(o.getName());
        if(nameComparison != 0) return nameComparison;
        return Integer.compare(this.id,o.getId());
    }
}

class Priorities{
    public List<StudentSimple> getStudents(List<String> events){
        PriorityQueue<StudentSimple> list = new PriorityQueue<>();
        for (String event:
            events ) {
            String[] str = event.split(" ");
            if(str.length > 1){
                String cmd = str[0];
                StudentSimple cur = new StudentSimple(Integer.parseInt(str[3]),str[1], Double.parseDouble(str[2]));
                list.add(cur);
            } else {
                if(list.peek() != null)
                list.poll();
            }
        }
        List<StudentSimple> res = new ArrayList<>();
        while (!list.isEmpty()){
            res.add(list.poll());
        }
        return res;
    }
}