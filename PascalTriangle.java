package Lab_2;

import java.util.Arrays;

public class PascalTriangle {
	// Phương thức này dùng để hiển thị Tam giác Pascal dựa trên số dòng (row)
	public static void printPascalTriangle(int row) {
		for (int i = 0; i < row; i++) {
			int[] currentRow = generateNextRow(i);
			for (int j = 0; j < currentRow.length; j++) {
				System.out.print(currentRow[j] + " ");
			}
			System.out.println();
		}
	}

	// Phương thức này dùng để lấy hàng thứ n trong Tam giác Pascal
	// Ví dụ: n=1 ==> {1}, n=2 ==> {1, 1}, ...
	public static int[] getPascalTriangle(int n) {
		return generateNextRow(n - 1);
	}

	// Phương thức này dùng để tạo hàng tiếp theo dựa trên hàng trước đó
	// Ví dụ: prevRow = {1} ==> nextRow = {1, 1}
	// Ví dụ: prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	public static int[] generateNextRow(int n) {
		int[] prevRow = { 1 }; // Hàng đầu tiên của Tam giác Pascal luôn là {1}
		for (int i = 1; i <= n; i++) {
			prevRow = generateNextRow(prevRow);
		}
		return prevRow;
	}

	// Phương thức này dùng để tạo hàng tiếp theo dựa trên hàng trước đó
	private static int[] generateNextRow(int[] prevRow) {
		int[] nextRow = new int[prevRow.length + 1];
		nextRow[0] = 1;
		nextRow[nextRow.length - 1] = 1;
		for (int i = 1; i < nextRow.length - 1; i++) {
			nextRow[i] = prevRow[i - 1] + prevRow[i];
		}
		return nextRow;
	}

	public static void main(String[] args) {
		int row = 5; // Thay đổi row thành số dòng bạn muốn hiển thị
		printPascalTriangle(row);

		int n = 4; // Thay đổi n thành hàng bạn muốn lấy từ Tam giác Pascal
		int[] pascalRow = getPascalTriangle(n);
		System.out.println("Row " + n + ": " + Arrays.toString(pascalRow));
	}
}
