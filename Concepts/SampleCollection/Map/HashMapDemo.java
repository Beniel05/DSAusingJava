import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {

        /*
         * HashMap
         * -------
         * - Stores data as Key-Value pairs.
         * - Keys must be unique.
         * - Values can be duplicated.
         * - Unordered collection.
         * - Implements the Map interface.
         */

        HashMap<String, Double> products = new HashMap<>();

        // Adding products
        products.put("Laptop", 55000.0);
        products.put("Mouse", 500.0);
        products.put("Keyboard", 1200.0);
        products.put("Monitor", 15000.0);
        products.put("Headphones", 2500.0);

        System.out.println("Product Catalog: " + products);

        // Accessing a value
        System.out.println("\nPrice of Laptop: ₹" + products.get("Laptop"));

        // Returns default value if key doesn't exist
        System.out.println("Price of Webcam: ₹" + products.getOrDefault("Webcam", 0.0));

        // Checking if a key exists
        System.out.println("\nContains Mouse? " + products.containsKey("Mouse"));
        System.out.println("Contains Printer? " + products.containsKey("Printer"));

        // Updating a value
        products.put("Mouse", 650.0);
        System.out.println("\nUpdated Mouse Price: ₹" + products.get("Mouse"));

        // Removing a product
        products.remove("Headphones");
        System.out.println("\nAfter Removing Headphones: " + products);

        // Size of HashMap
        System.out.println("\nNumber of Products: " + products.size());

        // All Keys
        System.out.println("\nProduct Names: " + products.keySet());

        // All Values
        System.out.println("Product Prices: " + products.values());

        // All Key-Value Pairs
        System.out.println("Entries: " + products.entrySet());

        // Traversing using keySet()
        System.out.println("\nTraversal using keySet():");

        for (String key : products.keySet()) {
            System.out.println(key + " -> ₹" + products.get(key));
        }

        // Traversing using entrySet()
        System.out.println("\nTraversal using entrySet():");

        for (Map.Entry<String, Double> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " -> ₹" + entry.getValue());
        }

        // Common DSA Use Case - Frequency Counting
        int[] sales = {101, 102, 101, 103, 102, 101};

        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int productId : sales) {
            frequency.put(
                    productId,
                    frequency.getOrDefault(productId, 0) + 1
            );
        }

        System.out.println("\nProduct Sales Frequency: " + frequency);

        // Clearing the HashMap
        products.clear();

        System.out.println("\nAfter Clear: " + products);
        System.out.println("Is Empty? " + products.isEmpty());
    }
}