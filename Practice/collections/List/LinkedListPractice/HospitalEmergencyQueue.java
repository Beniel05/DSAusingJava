import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HospitalEmergencyQueue {
    public static void main(String[] args) {

        LinkedList<String> patients = new LinkedList<>(
            List.of("John", "Alice", "David", "Sophia")
        );
        
        // Emergency Patient Arrives;
        patients.addFirst("Steve");
        
        while(!patients.isEmpty()) {
            String name = patients.poll();
            System.out.println("Treating: " + name);
        }
        /* OR
        Iterator<String> iterator = patients.iterator();
        while(iterator.hasNext()) {
            String name = iterator.next();
            System.out.println("Treating " + name);
            iterator.remove();
        }
        */
        
        // System.out.println(patients);
        // System.out.println(patients.poll() == null);

        if(patients.poll() == null) {
            System.out.println("No Patients Waiting");
        }
    }    
}
