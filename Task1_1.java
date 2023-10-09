package Lab_2;

public class Task1_1 {
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;

		}
		return (int) (getSn1(n - 1) + (Math.pow(-1, n + 1)) * n);
	}

	public static int getSn2(int n) {
		if (n == 0) {
			return 1;
		}
		return (getSn2(n - 1)) * n;
	}

	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		}
		return getSn3(n - 1) + n * n;
	}

	// Đây là một phương thức đệ quy để tính giai thừa của n sử dụng hàm f
	private static int f(int n) {
		if (n == 1) {
			return 2; // Giai thừa của 1 là 2
		}
		return f(n - 1) * n; // Tính giai thừa của n bằng cách nhân n với giai thừa của n-1
	}

	// Đây là một phương thức đệ quy để tính tổng theo công thức đã cho
	public static double getSn4(int n) {
		if (n == 0) {
			return 1; // Nếu n bằng 0, trả về 1
		}
		return getSn4(n - 1) + 1 / f(n); // Tính tổng S(n) = S(n-1) + 1/f(n)
	}

	public static void main(String[] args) {
		System.out.println(getSn1(4));
		System.out.println(getSn2(4));
		System.out.println(getSn3(3));
		System.out.println(getSn4(3));
	}
}
