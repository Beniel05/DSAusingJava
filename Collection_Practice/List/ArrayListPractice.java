import java.util.ArrayList;

public class ArrayListPractice {
    public static void main(String[] args) {
        
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Grapes");
        System.out.println(fruits);

        fruits.add(2, "Pineapple");
        System.out.println(fruits);

        int orangeIndex = fruits.indexOf("Orange");
        fruits.set(orangeIndex, "Watermelon");
        System.out.println(fruits);

        fruits.remove("Banana");
        System.out.println(fruits);

        fruits.remove(fruits.size() - 1);
        System.out.println(fruits);

        if(fruits.contains("Apple")) {
            System.out.println("Yes Apple is in the fruits.");
        } else {
            System.out.println("No Apple is in the fruits.");
        }
        
        if(fruits.contains("Kiwi")) {
            System.out.println("Yes Kiwi is in the fruits.");
        } else {
            System.out.println("No Kiwi is in the fruits.");
        }
        
        System.out.println("Total fruits = " + fruits.size());
    
        System.out.println("Middle: " + fruits.get(fruits.size() / 2));
        System.out.println("First: " + fruits.get(0));
        // System.out.println(fruits.getFirst());
        System.out.println("Last: " + fruits.get(fruits.size() - 1));
        // System.out.println(fruits.getLast());

        for(int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }
        
        // Enhaced for Loop
        for(String fruit : fruits) {
            System.out.println(fruit);
        }

        // For Each
        fruits.forEach(fruit -> System.out.println(fruit));
        // or
        fruits.forEach(System.out::println);

        fruits.clear();

        if(fruits.isEmpty()) {
            System.out.println("The fruits list is empty.");
        }
    }
}
