public class GenericsDemo {
    public static void main(String[] args) {

        Integer[] arr = { 1, 2, 3, 4, 5 };
        String[] str = { "one", "two", "three", "four", "five" };

        // To print these two different typed arrays. We need two different print methods.
        // But with Generics we use anonymous typed method which accepts every Type.
    
        printMethod(arr);
        printMethod(str);
    }

    // No need for printIntMethod, printStringMethod;
    // Instead a Single dynmanic Typed Method.
    public static <E> void printMethod(E[] array) {
        for(E item : array) {
            System.out.println(item);
        }
    }
}
