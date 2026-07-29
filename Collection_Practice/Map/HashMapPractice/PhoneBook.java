import java.util.HashMap;
import java.util.Iterator;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, Integer> contacts = new HashMap<>();

        contacts.put("Alice", 5550143);
        contacts.put("Bob", 5550172);
        contacts.put("Charlie", 5550198);
        contacts.put("Diana", 5550122);
        contacts.put("Evan Wright", 5550165);
        contacts.put("Fiona", 5550111);
        contacts.put("George Clark", 5550134);
        contacts.put("Hannah", 5550189);
        System.out.println(contacts);

        System.out.println(contacts.get("Bob"));

        contacts.put("Bob", 1234567);
        System.out.println(contacts);

        System.out.println(contacts.remove("Bob", 1234567));
        System.out.println(contacts);

        System.out.println(contacts.size());

        // Loop through this String -> Integer;

    }
}
