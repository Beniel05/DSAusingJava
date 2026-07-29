import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorPractice {
    public static void main(String[] args) {
        
        Vector<String> languages = new Vector<>(
            List.of("Java", "Python", "C++", "JavaScript", "Go")
        );
        System.out.println(languages);

        languages.add(2, "Kotlin");
        System.out.println(languages);

        int goIndex = languages.indexOf("Go");
        // int goIndex = languages.indexOf("Goa");
        if(goIndex != -1) {
            languages.set(goIndex, "Rust");
        }
        System.out.println(languages);

        languages.remove("Python");
        System.out.println(languages);

        languages.remove(3);
        System.out.println(languages);

        System.out.println(languages.get(0));
        System.out.println(languages.get(languages.size() - 1));

        if(languages.contains("Java")) {
            System.out.println("Java is in.");
        }

        System.out.println(languages.indexOf("Rust"));

        System.out.println(languages.size());
        System.out.println(languages.capacity());

        // for(String language : languages) {
        //     System.out.println(language);
        // }

        // for(int i = 0; i < languages.size(); i++) {
        //     System.out.println(languages.get(i));
        // }

        // Iterator<String> iterator = languages.iterator();
        // while (iterator.hasNext()) {
        //     System.out.println(iterator.next());
        // }

        // languages.forEach(language -> 
        //     { System.out.println(language); } 
        // );
        languages.forEach(System.out::println);


    }
}
