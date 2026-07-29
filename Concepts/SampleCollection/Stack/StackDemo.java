import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {

        // 1. Initialize Stack
        Stack<String> stack = new Stack<>();

        // 2. push() - Add elements
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry"); 
        System.out.println("Stack: " + stack); // Output: [Apple, Banana, Cherry]

        // 3. peek() - View top element
        System.out.println("Top Element: " + stack.peek()); // Output: Cherry

        // 4. search() - Find 1-based distance from top
        // "Cherry" is at position 1, "Banana" is at 2, "Apple" is at 3
        System.out.println("Position of 'Banana': " + stack.search("Banana")); // Output: 2

        // 5. pop() - Remove top element
        System.out.println("Popped: " + stack.pop()); // Output: Cherry
        System.out.println("Stack after pop: " + stack); // Output: [Apple, Banana]

        // 6. empty() - Check if stack is empty
        System.out.println("Is stack empty? " + stack.empty()); // Output: false

    }
}