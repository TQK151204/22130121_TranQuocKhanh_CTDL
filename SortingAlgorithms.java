package Lab_4;

public class SortingAlgorithms {
	// sort by descending order
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
				int temp = array[minIndex];
				array[minIndex] = array[i];
				array[i] = temp;
			}
		}
	}

	// sort by descending order
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int k = 0; k < array.length - 1 - i; k++) {
				if (array[k] > array[k + 1]) {
					int temp = array[k + 1];
					array[k + 1] = array[k];
					array[k] = temp;
				}
			}
		}

	}

	// sort by descending order
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;

		}

	}
	

	public static void main(String[] args) {
		int[] arr = { 2, 32, 72, 89, 8, 23 };
		selectionSort(arr);
		
		bubbleSort(arr);
		insertionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
