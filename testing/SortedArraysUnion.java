import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArraysUnion {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 5 };
        int[] arr2 = { 1, 2, 3, 4, 6 };

        List<Integer> unionArray = findUnion(arr1, arr2);
        System.out.println(unionArray);
    }

    static List<Integer> findUnion(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();

        int s1 = a.length;
        int s2 = b.length;
        int i = 0, j = 0;

        while (i < s1 && j < s2) {

            // a = {1,2,3,4}
            // b = {1,2,3,5}

            if (a[i] < b[j]) {
                if (list.size() == 0 || a[i] != list.get(list.size() - 1)) {
                    list.add(a[i]);
                }
                i++;
            } else if (a[i] > b[j]) {
                if (list.size() == 0 || b[j] != list.get(list.size() - 1)) {
                    list.add(b[j]);
                }
                j++;
            } else {
                if (list.size() == 0 || a[i] != list.get(list.size() - 1)) {
                    list.add(a[i]);
                    i++;
                    j++;
                }
            }

        }

        while (i < s1) {
            if (list.size() == 0 || a[i] != list.get(list.size() - 1)) {
                list.add(a[i]);
            }
            i++;
        }

        while (j < s2) {
            if (list.size() == 0 || b[j] != list.get(list.size() - 1)) {
                list.add(b[j]);
            }
            j++;
        }

        return list;
    }
}