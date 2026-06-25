import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 7, 10};
        int[] a2 = {2, 4, 6, 8, 10};

        List<Integer> betterResult = findUnionBETTER(a1, a2);
        List<Integer> bruteResult = findUnionBRUTE(a1, a2);

        System.out.println(betterResult);
        System.out.println(bruteResult);
    }

    /*
        ==== BETTER APPROACH BELOW ====
    */

    public static List<Integer> findUnionBETTER(int[] a1, int[] a2) {
        Set<Integer> st = new TreeSet<>();

        for(int i : a1) {
            st.add(i);
        }

        for(int i : a2) {
            st.add(i);
        }
        
        return new ArrayList<>(st);
    }

    /*
        ==== BRUTE APPROACH BELOW ====
    */

    public static ArrayList<Integer> findUnionBRUTE(int[] a1, int[] a2) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int element : a1) {
            if(!(contains(list, element))) {
                list.add(element);
            }
        }

        for(int element : a2) {
            if(!(contains(list, element))) {
                list.add(element);
            }
        }

        Collections.sort(list);
        return list;
    }

    public static boolean contains(ArrayList<Integer> list, int value) {
        for(int i = 0; i < list.size(); i++) {
            if(value == list.get(i)) {
                return true;
            }
        }
        return false;
    }
}