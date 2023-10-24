package Lab_5;

import java.util.Arrays;
import java.util.Iterator;

public class Arrays2D {
	public static int[][] add(int[][] a, int[][] b) {
		if ((a.length != b.length) || (a[0].length != b[0].length)) {
			return null;
		}
		int row = a.length;
		int col = a[0].length;
		int[][] result = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result[i][j] = a[i][j] + b[i][j];

			}
		}
		return result;

	}

	public static int[][] subtract(int[][] a, int[][] b) {
		if ((a.length != b.length) || (a[0].length != b[0].length)) {
			return null;
		}
		int row = a.length;
		int col = a[0].length;
		int[][] result = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result[i][j] = a[i][j] - b[i][j];

			}
		}
		return result;

	}

	public static int[][] multiply(int[][] a, int[][] b) {
		int aRow = a.length;
		int aCol = a[0].length;
		int bRow = b.length;
		int bCol = b[0].length;
		if (aCol != bRow) {
			return null;
		}
		int result[][] = new int[aRow][bCol];
		for (int i = 0; i < aRow; i++) {
			for (int j = 0; j < bCol; j++) {
				int sum = 0;
				for (int k = 0; k < aCol; k++) {
					sum += a[i][k] * b[k][j];
				}
				result[i][j] = sum;
			}
		}

		return result;
	}

	public static int[][] transpose(int[][] a) {
		int numRow = a.length;
		int numCol = a[0].length;
		
		int result [][] = new int [numCol][numRow];
		for (int i = 0; i < numRow; i++) {
			for (int j = 0; j <numCol; j++) {
				result[j][i]= a[i][j];
			}
		}
				
		return result;
	}

	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int element : row) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 7, 2 }, { 5, 3 } };

		int[][] b = { { 2, 1 }, { 3, 1 } };
		int result[][] = add(a, b);
		int result2[][] = subtract(a, b);
		int result3[][] = transpose(a);
		printMatrix(result);
		printMatrix(result2);
		printMatrix(result3);

	}

}
