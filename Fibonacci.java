package Lab_2;

public class Fibonacci {
	public static int getFibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return getFibonacci(n - 1) + getFibonacci(n - 2);

	}

	public static void printFibonacci(int n) {
		if (n <= 0) {
			System.out.println("Dữ liệu đầu vào không đúng" + n);
			return;
		}
		for (int i = 0; i < n; i++) {
			System.out.print(getFibonacci(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		printFibonacci(10);
	}
}
