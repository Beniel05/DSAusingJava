package Practice.collections.Map;
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();

        students.put(1, "Alex");
        students.put(2, "Bob");
        students.put(3, "Charles");
        students.put(4, "Farhana");
        students.put(5, "Eric");
        students.put(6, "Doe");

        System.out.println(students);

        System.out.println(students.get(3));

        System.out.println(students.get(100));
        System.out.println(students.containsKey(100));

        if(!students.containsKey(100)) {
            System.out.println("No student with that KEY");
        }

        System.out.println(students.size());
        students.put(6, "New student");
        
        System.out.println(students);
        System.out.println(students.size());
    }
}
