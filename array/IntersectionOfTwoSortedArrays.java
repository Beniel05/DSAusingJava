import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        
        int[] a = {1, 2, 2, 3, 3, 4, 5, 6, 7};
        int[] b = {2, 3, 3, 5, 6, 6, 7};

        // These all will have duplicates - if both array have the same value more than once.
        ArrayList<Integer> bruteResult = brute(a, b);
        ArrayList<Integer> optimizedResult = optimizedTwoPointer(a, b);

        System.out.println(bruteResult);
        System.out.println(optimizedResult);

        // The below will have a Unique Result - no repetition
        ArrayList<Integer> uniqueResult = uniqueIntersection(a, b);
        System.out.println(uniqueResult);
    }

    public static ArrayList<Integer> uniqueIntersection(int[] a, int[] b) {
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0, j = 0;
        int n1 = a.length;
        int n2 = b.length;

        while(i < n1 && j < n2) {
            if(a[i] < b[j]) {
                i++;
            } else if(a[i] > b[j]) {
                j++;
            } else {
                if(list.size() == 0 || list.get(list.size() - 1) != a[i]) {
                    list.add(a[i]);
                }
                i++;
                j++;
            }
        }
        return list;
    }

    public static ArrayList<Integer> brute(int[] a, int[] b) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int n1 = a.length;
        int n2 = b.length;
        int[] vis = new int[n2];

        for(int i = 0; i < n1; i++) {
            for(int j = 0; j < n2; j++) {
                if(a[i] == b[j] && vis[j] == 0) {
                    list.add(b[j]);
                    vis[j] = 1;
                    break;
                }
                if(b[j] > a[i]) {
                    // Since it is a sorted Array we don't have to check after larger number
                    break;
                }
            }
        }
        return list;
    }

    static ArrayList<Integer> optimizedTwoPointer(int[] a, int[] b) {
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0, j = 0;
        int n1 = a.length, n2 = b.length;

        while(i < n1 && j < n2) {
            if(a[i] < b[j]) {
                i++;
            } else if(a[i] == b[j]) {
                list.add(b[j]);
                i++;
                j++;
            } else if(a[i] > b[j]) {
                // simple 'else' can be used.
                j++;
            }
        }
        return list;
    }

}
