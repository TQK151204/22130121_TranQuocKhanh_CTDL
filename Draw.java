package Lab_2;

import java.util.Iterator;

public class Draw {
	public static void drawPyramid(int n) {
		if (n <= 0) {
			System.out.println("Dữ liệu đầu vào không hợp lệ !");
			return;
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - i - 1; j++) {
					System.out.print(" ");
				}
				for (int k = 0; k < 2 * i + 1; k++) {
					System.out.print("X");
				}
				System.out.println();
			}
		}

	}

	public static void drawPyramid2(int n) {
		drawPyramidHelper(n, 1);
	}

	

	private static void drawPyramidHelper(int n, int row) {
		if(row >n) {
			return;
		}
		for (int i = 1; i <= n-row; i++) {
			System.out.print(" ");
		}
		for (int i = 1; i <= 2*row -1; i++) {
			System.out.print("X");
		}
		System.out.println();
		drawPyramidHelper(n,row+1);
	}
	

	public static void main(String[] args) {
		drawPyramid(5);
		drawPyramid2(4);
	}

}
