package Lab_1;

import java.util.HashSet;

public class MyArray {
    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    
    public int[] mirror() {
        int n = array.length;
        int[] mirroredArray = new int[2 * n];

        for (int i = 0; i < n; i++) {
            mirroredArray[i] = array[i];
            mirroredArray[2 * n - 1 - i] = array[i];
        }

        return mirroredArray;
    }

   
    public int[] removeDuplicates() {
        HashSet<Integer> uniqueElements = new HashSet<>();
        int n = array.length;

       
        for (int i = 0; i < n; i++) {
            uniqueElements.add(array[i]);
        }

       
        int[] uniqueArray = new int[uniqueElements.size()];
        int index = 0;

        
        for (int num : uniqueElements) {
            uniqueArray[index++] = num;
        }

        return uniqueArray;
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3};
        MyArray myArray = new MyArray(originalArray);

        int[] mirroredResult = myArray.mirror();
        int[] removeDuplicatesResult = myArray.removeDuplicates();

       
        System.out.print("Mirror Result: ");
        for (int num : mirroredResult) {
            System.out.print(num + " ");
        }

        System.out.println();

        System.out.print("Remove Duplicates Result: ");
        for (int num : removeDuplicatesResult) {
            System.out.print(num + " ");
        }
    }
}

