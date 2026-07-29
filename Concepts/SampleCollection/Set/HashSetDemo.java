import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {

        /*
         * HashSet
         * -------
         * - Stores only unique values.
         * - Duplicate values are automatically ignored.
         * - Unordered collection.
         * - No indexing support.
         * - Implements the Set interface.
         */

        HashSet<String> products = new HashSet<>();

        // Adding products
        products.add("Laptop");
        products.add("Mouse");
        products.add("Keyboard");
        products.add("Monitor");
        products.add("Headphones");

        System.out.println("Products: " + products);

        // Duplicate values are ignored
        products.add("Laptop");
        products.add("Mouse");

        System.out.println("\nAfter Adding Duplicates: " + products);

        // Checking if an element exists
        System.out.println("\nContains Laptop? " + products.contains("Laptop"));
        System.out.println("Contains Printer? " + products.contains("Printer"));

        // Removing an element
        products.remove("Headphones");

        System.out.println("\nAfter Removing Headphones: " + products);

        // Size of HashSet
        System.out.println("\nNumber of Products: " + products.size());

        // Traversing the HashSet
        System.out.println("\nProduct List:");

        for (String product : products) {
            System.out.println(product);
        }

        // Common DSA Use Case - Finding Unique Values
        int[] productIds = {101, 102, 101, 103, 102, 104, 105, 104};

        HashSet<Integer> uniqueProducts = new HashSet<>();

        for (int id : productIds) {
            uniqueProducts.add(id);
        }

        System.out.println("\nUnique Product IDs: " + uniqueProducts);

        // Checking if the set is empty
        System.out.println("\nIs Empty? " + products.isEmpty());

        // Clearing the HashSet
        products.clear();

        System.out.println("\nAfter Clear: " + products);
        System.out.println("Is Empty? " + products.isEmpty());
    }
}