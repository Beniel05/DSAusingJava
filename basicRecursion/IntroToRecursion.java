public class IntroToRecursion {

    /* Important definitions to know.
    * **Recursion** → A technique where a method calls itself repeatedly until a condition is satisfied - to solve smaller parts of a problem.
    * **Base Case** → The stopping condition in recursion that prevents infinite method calls. 
    * **Stack Overflow** → An error that occurs when too many recursive calls fill up the call stack memory.
    * **Stack Space** → The memory used by the call stack to store method calls, local variables, and return addresses during execution.
    * **Recursion Tree** → A tree-like representation showing how recursive calls are divided and executed step by step. 
     */

    static int count = 1;

    static void print() {
        if (count == 4)
            return;
        System.out.println(count);
        count++;
        print();
    }

    public static void main(String[] args) {
        print();
    }
}
