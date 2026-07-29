import java.util.LinkedList;
import java.util.Scanner;

public class TextEditor {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        LinkedList<String> textEditor = new LinkedList<>();

        System.out.println("Enter 3 Strings on each new line; ");

        textEditor.addFirst(sc.nextLine());
        textEditor.addFirst(sc.nextLine());
        textEditor.addFirst(sc.nextLine());

        System.out.println("\nImagine 2 Undo happens;");
        for(int i = 0; i < 2; i++) {
            System.out.println("Undo : " + textEditor.pollFirst());
        }

        // System.out.println("Remaining: " + textEditor.getFirst());
        // System.out.println("Remaining: " + textEditor.peekFirst());
        System.out.println("Remaining: " + textEditor.pollFirst());

        sc.close();
    }
}
