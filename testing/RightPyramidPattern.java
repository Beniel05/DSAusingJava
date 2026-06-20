public class RightPyramidPattern {
    public static void main(String[] args) {
        // Height = 4;
        int height = 4;

        for (int i = 1; i < 2 * height; i++) {
            int stars = (i <= height) ? i : (2 * height - i);
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("=== OR ===");

        for (int i = 1; i < height + 1; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();	
		}
		for (int i = height - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();	
		}
    }

}
