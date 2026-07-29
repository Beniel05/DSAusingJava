import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

    // Customized Ordered Comparison = Comparator
    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<>(
            List.of(19, 28, 36, 53, 91)
        );
        
        /*
        Comparator<Integer> com = new Comparator<>() {
            public int compare(Integer n1, Integer n2) {
                if(n1 % 10 > n2 % 10) {
                    return 1;
                    } else {
                        return -1;
                }
            }
        };
        
        Collections.sort(list, com);
        */
       
        Collections.sort(list, (n1, n2) -> Integer.compare(n1 % 10, n2 % 10));
        
        System.out.println(list);

    }
}
