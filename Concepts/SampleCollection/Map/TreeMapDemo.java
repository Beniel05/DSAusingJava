import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {

        /*
         * TreeMap
         * -------
         * - Stores data as Key-Value pairs.
         * - Keys must be unique.
         * - Values can be duplicated.
         * - Keys are automatically sorted.
         * - Implements the Map interface.
         */

        TreeMap<String, Double> products = new TreeMap<>();

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

        // Size of TreeMap
        System.out.println("\nNumber of Products: " + products.size());

        // First and Last Keys
        System.out.println("\nFirst Product: " + products.firstKey());
        System.out.println("Last Product: " + products.lastKey());

        // Higher and Lower Keys
        System.out.println("\nProduct After Keyboard: " + products.higherKey("Keyboard"));
        System.out.println("Product Before Keyboard: " + products.lowerKey("Keyboard"));

        // All Keys
        System.out.println("\nProduct Names: " + products.keySet());

        // All Values
        System.out.println("Product Prices: " + products.values());

        // Traversing using entrySet()
        System.out.println("\nComplete Product Catalog:");

        for (Map.Entry<String, Double> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " -> ₹" + entry.getValue());
        }

        // Clearing the TreeMap
        products.clear();

        System.out.println("\nAfter Clear: " + products);
        System.out.println("Is Empty? " + products.isEmpty());
    }
}