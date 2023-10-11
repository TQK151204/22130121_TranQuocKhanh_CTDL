package Lab_3;

public class Task1_3 {
	private int[] arr;

	public Task1_3(int[] arr) {

		this.arr = arr;
	}

	public int iterativeBinarySearchDescending(int target) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == arr[mid]) {
				return mid;
			} else if (target > arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;

	}

	public int recursiveBinarySearchDescending(int target) {
		int low = 0;
		int high = arr.length - 1;
		return recursiveBinarySearchDescendingHelp(arr, target, low, high);
	}

	private int recursiveBinarySearchDescendingHelp(int[] arr, int target, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (target > arr[mid]) { 
				return recursiveBinarySearchDescendingHelp(arr, target, low, mid - 1);
			} else {
				return recursiveBinarySearchDescendingHelp(arr, target, mid + 1, high);
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		
		int[] array2 = {85, 70, 66, 28, 12, 8 ,7, 5};
		Task1_3 mA2 = new Task1_3(array2);
		System.out.println(mA2.recursiveBinarySearchDescending(70));
		System.out.println(mA2.iterativeBinarySearchDescending(7));
	}

}
