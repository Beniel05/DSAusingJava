public class IntegerparseInt {
    public static void main(String[] args) {
        // this String[] array will take arguments when we run this java class
        // eg: java IntegerparseInt 25 30

        // Lets take the String args and convert them into integer and add them;
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        // now compile this class using;
        //      javac IntegerparseInt.java
        // run this class using;
        //      java IntegerparseInt 25 30

        System.out.println(a + b); // 55 <= (25 + 30)

    }
}
