import java.util.HashMap;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, Integer> contacts = new HashMap<>();

        contacts.put("Alice", 55501443);
        contacts.put("Bob", 55501724);
        contacts.put("Charlie", 55501938);
        contacts.put("Diana", 55501222);
        contacts.put("Evan Wright", 55501655);
        contacts.put("Fiona", 55501171);
        contacts.put("George Clark", 55501354);
        contacts.put("Hannah", 55501889);
        System.out.println(contacts);

        System.out.println(contacts.get("Bob"));

        contacts.put("Bob", 12345670);
        System.out.println(contacts);

        System.out.println(contacts.remove("Bob", 12345670));
        System.out.println(contacts);

        System.out.println(contacts.size());

        // Loop through this String -> Integer;
        int size = contacts.size();
        for(int i = 0; i < size; i++) {
            System.out.println(contacts.get(i));
        }
    }
}
