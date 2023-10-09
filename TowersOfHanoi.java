package Lab_2;

public class TowersOfHanoi {
	public static void MoveTower(int n, char nguon, char dich, char trungGian) {
		if (n == 1) {
			System.out.println("Chuyển 1 địa chỉ " + nguon + " sang " + dich);
		} else {
			// chuyển n-1 đĩa từ cọc nguồn sang cọc trung gian,
			// lấy cọc đích làm cọc phụ
			MoveTower(n - 1, nguon, trungGian, dich);

			// chuyển còn lại từ cọc nguồn sang cọc đích
			System.out.println("Chuyển 1 địa chỉ " + nguon + " sang " + dich);
			// chuyễn n-1 từ cọc trung gian về cọc đích,
			// lấy cọc nguồn làm cọc trung gian
			MoveTower(n - 1, trungGian, dich, nguon);
		}

	}

	public static void main(String[] args) {
		MoveTower(3, 'A', 'C', 'B');
	}
}
