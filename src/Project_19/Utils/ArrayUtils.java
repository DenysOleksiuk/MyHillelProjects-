package Project_19.Utils;

public class ArrayUtils {


    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }


    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int lArr[] = new int[n1];
        int rArr[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            lArr[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            rArr[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (lArr[i] <= rArr[j]) {
               arr[k++] = lArr[i++];
            } else {
                arr[k++] = rArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = lArr[i++];
        }

        while (j < n2) {
            arr[k++] = rArr[j++];
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
