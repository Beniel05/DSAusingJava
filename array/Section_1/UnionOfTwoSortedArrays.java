package Section_1;
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
        List<Integer> optimizedResult = findUnionOPTIMIZEDtwoPointer(a1, a2);

        System.out.println(betterResult);
        System.out.println(bruteResult);
        System.out.println(optimizedResult);
    }

     /*
        ==== OPTIMIZED APPROACH BELOW ====
    */

    public static ArrayList<Integer> findUnionOPTIMIZEDtwoPointer(int[] a1, int[] a2) {
        ArrayList<Integer> list = new ArrayList<>();

        int n1 = a1.length;
        int n2 = a2.length;
        int i = 0;
        int j = 0;
        // boolean isListEmpty = list.size() == 0;
        // a1 = {1, 1, 2, 3, 4, 5}
        // a2 = {2, 3, 4, 4, 5, 6}

        while (i < n1 && j < n2) {

            if(a1[i] < a2[j]) {
                if(list.isEmpty() || a1[i] != list.get(list.size() - 1)) {
                    // Compare with the last element already added to avoid duplicates.
                    list.add(a1[i]);
                }
                i++;
            }
            else if (a1[i] > a2[j]) {
                if(list.isEmpty() || a2[j] != list.get(list.size() - 1)) {
                    list.add(a2[j]);
                }
                j++;
            }
            else {
                // Both arrays contain the same value. Add it once and move both pointers.
                // Include it only once - and increment both varibale.
                if(list.isEmpty() || a1[i] != list.get(list.size() - 1)) {
                    list.add(a1[i]); // a2[j] is also the same value
                }
                i++; j++;
            }

        }

        while (i < n1) {
            if(list.isEmpty() || a1[i] != list.get(list.size() - 1)) {
                list.add(a1[i]);
            }
            i++;
        }

        while (j < n2) {
            if(list.isEmpty() || a2[j] != list.get(list.size() - 1)) {
                list.add(a2[j]);
            }
            j++;
        }


        return list;
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