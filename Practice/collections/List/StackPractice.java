import java.util.EmptyStackException;
import java.util.Stack;

public class StackPractice {
    public static void main(String[] args) {
        // languages();
        // popNumber();
        // peekNumber();
        // emptyMethod();
        // untilEmpty();
        // untilEmpty2();
        search_IndexOf_LastIndexOf();
    }
    
   public static void languages() {
       Stack<String> stack = new Stack<>();
   
           stack.push("C");
           stack.push("C++");
           stack.push("Java");
           stack.push("JavaScript");
           stack.push("Python");
   
           System.out.println(stack);
   }

   public static void popNumber() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack);
   }

   public static void peekNumber() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.peek());
        System.out.println(stack);
   }

   public static void emptyMethod() {
        Stack<Integer> stack = new Stack<>();

        System.out.println(stack.empty());
        stack.push(1);
        System.out.println(stack.empty());

        System.out.println(stack);
   }

   public static void searchMethod() {
    // search works with 1 based indexing - will start from the last.
    // if not found => -1.

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println(stack.search(50));
        System.out.println(stack.search(30));
        System.out.println(stack.search(100));
   }

   public static void untilEmpty() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        while(!stack.empty()) {
            System.out.println(stack.pop());
        }

        // stack is empty now
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println(e);
        }
   }

   public static void untilEmpty2() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while(!stack.empty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
   }

   public static void search_IndexOf_LastIndexOf() {
        Stack<String> stack = new Stack<>();

        stack.push("Java");
        stack.push("Python");
        stack.push("Java");
        stack.push("C");
        stack.push("Java");
        stack.push("C++");

        System.out.println(stack.search("Java")); // last Java before C++; Stack method so 1 based indexing fromt the last (Top)
        System.out.println(stack.indexOf("Java")); // Vector's method -> First index 0.
        System.out.println(stack.lastIndexOf("Java")); // Last Java before C++; Vector's method so 0 based indexing from the first (Bottom)

   }
}
