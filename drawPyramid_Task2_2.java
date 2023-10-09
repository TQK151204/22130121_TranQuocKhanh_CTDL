package Lab_2;

public class drawPyramid_Task2_2 {
	public static void PyramidPattern_4(int n) {
		 for (int i = 1; i <= n; i++) {
	            // In khoảng trống (space) trước dấu '*' để tạo khoảng cách
	            for (int j = 1; j <= n - i+3; j++) {
	                System.out.print(" ");
	            }
	            
	            // In dấu '*' cho từng dòng
	            for (int j = 1; j <= i; j++) {
	                System.out.print("*");
	            }
	            
	            // Xuống dòng để bắt đầu dòng tiếp theo
	            System.out.println();
	        }
	    
	}

	public static void PyramidPattern_3(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = n; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i * 2 - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		PyramidPattern_4(20);

	}

}
