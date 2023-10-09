package Lab_2;

public class Task2_3 {
	public static void drawChristmasTree(int n) {
	    if (n <= 0) {
	        return;
	    }
	    
	    // Draw the pyramid for the current level (height)
	    drawPyramid(n);
	    
	    // Recursively draw the rest of the tree
	    drawChristmasTree(n -1);
	}

	public static void drawPyramid(int height) {
	    // Draw a pyramid of the given height
	    for (int i = 1; i <= height; i++) {
	        // Print spaces before the Xs
	        for (int j = height - i; j > 0; j--) {
	            System.out.print("  ");
	        }
	        
	        // Print Xs for the current level
	        	for (int j = 1; j <= 2 * i - 1; j++) {
	            System.out.print("X");
	        }
	        
	        // Move to the next line
	        System.out.println();
	    }
	}

	public static void main(String[] args) {
	    int n = 4; // Change this value to the desired height of the Christmas tree
	    drawChristmasTree(n);
	}
}

