package Project_19.App;

import Project_19.Utils.ArrayUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayUtils arrayUtils = new ArrayUtils();

        int[] arr = createArray();

      System.out.println("Original array: " + java.util.Arrays.toString(arr));

        arrayUtils.mergeSort(arr);

        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));

       if (arrayUtils.binarySearch(arr, 50) != -1) {
           System.out.println("Element found at index: " + arrayUtils.binarySearch(arr, 50));
       }else {
           System.out.println("Element not found.");
       }


    }

    public static int[] createArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] =  (int )(Math.random() * 100);
        }
        return arr;
    }
}
