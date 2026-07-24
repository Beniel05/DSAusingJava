import java.util.LinkedList;
import java.util.List;

public class Songs {
    public static void main(String[] args) {
        
        LinkedList<String> songs = new LinkedList<>(
        List.of("Believer", "Perfect", "Faded", "Alone")
        );
        
        System.out.println(songs);

        // Playing the first song - remove after it played.
        
        System.out.println(songs.peek());
        // getFirst() will throw NoSuchElementException when the list is empty.
        // But peek() return null if the list is empty
        songs.removeFirst();
        // OR;
        // System.out.println(songs.poll()); // pollFirst() -- both do the same job.

        System.out.println(songs);

        songs.addLast("Shape of You");

        System.out.println(songs);

        int size = songs.size();
        // If we directly mention songs.size() in loop -> it'll change into half dynamically
        for(int i = 0; i < size; i++) {
            // System.out.println(songs.peek());
            // songs.removeFirst();
            System.out.println(songs.pollFirst());
        }

        System.out.println(songs);
        System.out.println(songs.poll());

        if(songs.isEmpty()) {
            System.out.println("Playlist Finished");
        }
    }
}
