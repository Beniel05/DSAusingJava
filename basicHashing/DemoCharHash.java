import java.util.Arrays;
import java.util.Scanner;

public class DemoCharHash {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        String str = "abcdabefc";
        char[] c = str.toCharArray();
        // System.out.println(c[3]);

        int[] hash = new int[256];
        for(int i = 0; i < str.length(); i++) {
            hash[c[i]] += 1;
        }

        System.out.println("Original String as CHAR array: " + Arrays.toString(c));
        // System.out.println(Arrays.toString(hash));

        System.out.print("Enter the total number of queries: ");
        int totalQueries = sc.nextInt();
        while(totalQueries-- > 0) {
            System.out.print("Enter the CHAR to find it's occurence: ");
            char ch = sc.next().charAt(0);
            System.out.println("'" + ch + "'" + " occured : " + hash[ch] + " times.");;
        }

    }
}
