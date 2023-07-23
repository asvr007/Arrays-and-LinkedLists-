
import java.util.*;

 class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<>(new Comparator<Student>() {
                @Override
                public int compare(Student a, Student b) {
                    if (a.getCGPA() != b.getCGPA()) {
                        return Double.compare(b.getCGPA(), a.getCGPA());
                    } else if (!a.getName().equals(b.getName())) {
                        return a.getName().compareTo(b.getName());
                    } else {
                        return Integer.compare(a.getID(), b.getID());
                    }
                }
            }
        );

        List<Student> students = new ArrayList<>();

        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                queue.offer(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                queue.poll();
            }
        }

        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }

        return students;
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
