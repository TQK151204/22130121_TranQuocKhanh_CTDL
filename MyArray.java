package Lab_3;

public class MyArray {
	private int[] arr;

	public MyArray(int[] arr) {

		this.arr = arr;
	}
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < arr.length; i++) {
			if(target == arr[i]) {
				return i;
			}
		}
		return -1;
	}
	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearchHelp(target,0);
	}
	private int recursiveLinearSearchHelp(int target, int number) {
		if(number >= arr.length) {
			return -1;
		}else {
				if(target== arr[number]) {
					return number;
				
			}
				return recursiveLinearSearchHelp(target, number+1);
		}
		
		
	}
	public int iterativeBinarySearch(int target) {
		int low =0;
		int high = arr.length -1;
		while(low <=high) {
			int mid = (low +high)/2;
			if(target == arr[mid]) {
				return mid;
			}else if(target < arr[mid]) {
				high= mid -1;
			}else {
				low= mid +1;
			}
		}
		return -1;
	}
	public int recursiveBinarySearch(int target) {
		int low =0;
		int high= arr.length -1;
		return recursiveBinarySearchHelp(arr,target,low,high);
	}
	private int recursiveBinarySearchHelp(int[] arr, int target, int low, int high) {
		if (low <= high) {
	        int mid = low + (high - low) / 2; // Calculate the middle index correctly
	        if (arr[mid] == target) {
	            return mid; // Element found, return its index
	        } else if (target < arr[mid]) {
	            return recursiveBinarySearchHelp(arr, target, low, mid - 1); // Search in the left half
	        } else {
	            return recursiveBinarySearchHelp(arr, target, mid + 1, high); // Search in the right half
	        }
	    }
	    return -1; // Element not found
		
		
	}
	public static void main(String[] args) {
		int[] array = {12, 10, 9, 45, 2, 10, 10, 45};
		MyArray mA = new MyArray(array);
		System.out.println(mA.iterativeLinearSearch(45));
		System.out.println(mA.recursiveLinearSearch(45));
		int[] array2 = {8, 10, 19, 25, 28, 66, 70, 85};
		MyArray mA2 = new MyArray(array2);
		System.out.println(mA2.iterativeBinarySearch(8));
		System.out.println(mA2.recursiveBinarySearch(10));
	}

}
