import java.util.HashMap;

public class ProductPriceCatelog {
    public static void main(String[] args) {

        // Product Name, Price
        HashMap<String, Double> products = new HashMap<>();

        products.put("Headphones", 39999.99);
        products.put("MacBook", 159999.00);
        products.put("Mouse", 1099.95);
        products.put("Kindle Paperwhite", 1549.99);
        products.put("Power Bank", 1029.99);
        products.put("Samsung Portable SSD", 6699.50);
        products.put("Keyboard", 3_49_000.99);

        System.out.println(products);

        System.out.println(products.get("Keyboard"));

        System.out.println(products.getOrDefault("Shampoo", 0.0));

        products.put("Samsung Portable SSD", 5599.00);
        System.out.println(products);

    }
}
