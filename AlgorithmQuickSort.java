package Lab_4;

public class AlgorithmQuickSort {
	// sort by ascending order 
	public static void quickSort (int[] array) { 
	 	if(array == null || array.length == 0) {
	 		return;
	 	}
	 	quickSort(array,0,array.length -1);
	}

	private static void quickSort(int[] array, int left, int right) {
		if(left < right) {
			int pivotIndex = partition(array,left,right);
			quickSort(array,left,pivotIndex -1);
			quickSort(array,pivotIndex +1 , right);
		}
		
	}

	private static int partition(int[] array, int left, int right) {
		int pivot = array[right];
		int i = left -1 ;
		for (int j = left; j < right; j++) {
			if(array[j] <= pivot) {
				i++;
				swap(array,i,j);
			}
		}
		swap(array, i+1, right);
		return i +1;
		
		
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	} 
	private static int getPivot_MedianOfThree(int[]	array) {
			
		
	
		return 0;
			}

	  public static void main(String[] args) {
	        int[] array = {5, 2, 9, 3, 4, 6};
	        quickSort(array);
	        for (int num : array) {
	            System.out.print(num + " ");
	        }
	    }

}
