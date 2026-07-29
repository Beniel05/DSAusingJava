import java.util.LinkedList;
import java.util.List;

public class LinkedListPractice {
    public static void main(String[] args) {

        LinkedList<String> fruits = new LinkedList<>();
        // <Number> example in new end of this class.s

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        // All shares O(1)
        System.out.println(fruits);

        fruits.addFirst("Mango");
        // fruits.add(0, "Mango");
        // O(1)
        System.out.println(fruits);

        fruits.add("Pineapple");
        // O(1)
        System.out.println(fruits);

        // Getting first element (head) = O(1).
        System.out.println(fruits.get(0));
        // or - both the below will return value - we have to print it
        // fruits.getFirst();
        // fruits.peekFirst();

        // Getting last eleement (tail) = O(1).
        System.out.println(fruits.get(fruits.size() - 1));
        // or - those below will return value we have to print it.
        // fruits.getLast();
        // fruits.peekLast();

        // Getting middle elements = O(n) - travesrsing each previous nodes.
        System.out.println(fruits.get(fruits.size() / 2));

        // Replacing Orange with Grapes;
        int orangeIndex = fruits.indexOf("Orange");
        fruits.set(orangeIndex, "Grapes");
        // Accessing by Index = O(n) - traversal.
        System.out.println(fruits);

        // Removing first O(1)
        // fruits.removeFirst();
        fruits.remove(0);
        System.out.println(fruits);

        // Removing last O(1)
        fruits.removeLast();
        System.out.println(fruits);

        // Removing Object O(n) - traversal
        fruits.remove("Banana");

        System.out.println(" ======================================= ");

        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("===== Peek, Get and Poll =====");
        // Just gets the first element.
        System.out.println(list.peek());
        System.out.println(list.getFirst());
        System.out.println(list.peekFirst());
        System.out.println(list);
        // Get the first element then removes it.
        System.out.println(list.poll());
        System.out.println(list);
        // O(1) - Overall

        list.clear();

        System.out.println(list.peek());
        System.out.println(list.getFirst());

        System.out.println("==========================================");
        LinkedList<String> studentQueue = new LinkedList<>();

        // 1. Student Queue
        studentQueue.add("Alice");
        studentQueue.add("Bob");
        studentQueue.add("Charlie");
        System.out.println(studentQueue);

        studentQueue.addFirst("David");
        System.out.println(studentQueue);

        studentQueue.removeFirst();
        System.out.println(studentQueue);

        System.out.println("==========================================");
        LinkedList<String> browserHistory = new LinkedList<>();

        // 2. Browser History
        browserHistory.add("Google");
        browserHistory.add("GitHub");
        browserHistory.add("YouTube");
        browserHistory.add("ChatGPT");
        System.out.println(browserHistory);

        // Current page;
        System.out.println(browserHistory.getLast());

        // Removing recent visited page;
        browserHistory.removeLast();
        System.out.println(browserHistory);

        // Current page again;
        System.out.println(browserHistory.getLast());

        System.out.println("==========================================");
        LinkedList<String> fruits2 = new LinkedList<>();

        fruits2.add("Apple");
        fruits2.add("Mango");
        fruits2.add("Orange");
        fruits2.add("Banana");
        fruits2.add("Orange");
        System.out.println(fruits2);

        // Replacing first Orange -> Grapes
        int oraIndex = fruits2.indexOf("Orange");
        if (oraIndex == -1) {
            System.out.println("Element not found.");
        } else {
            fruits2.set(oraIndex, "Grapes");
        }
        System.out.println(fruits2);

        System.out.println("==========================================");
        LinkedList<String> trainCompartments = new LinkedList<>();

        trainCompartments.add("Engine");
        trainCompartments.add("A1");
        trainCompartments.add("A2");
        trainCompartments.add("A3");
        trainCompartments.add("Guard");
        System.out.println(trainCompartments);

        // Insert "Pantry" before "Guard".
        int guardIndex = trainCompartments.indexOf("Guard");
        if (guardIndex == -1) {
            System.out.println("Element not found.");
        } else {
            trainCompartments.add(guardIndex, "Pantry");
        }

        // Remove A2;
        trainCompartments.remove("A2");
        System.out.println(trainCompartments);

        System.out.println("==========================================");
        LinkedList<Integer> numbers = new LinkedList<>(List.of(10, 20, 30, 40, 50));

        System.out.println(numbers);

        numbers.removeFirst();
        System.out.println(numbers);

        numbers.removeLast();
        System.out.println(numbers);

        numbers.addLast(60);
        System.out.println(numbers);

        System.out.println("First: " + numbers.getFirst());
        System.out.println("Last: " + numbers.getLast());

    }
}