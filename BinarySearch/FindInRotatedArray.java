package BinarySearch;

public class FindInRotatedArray {
    public static int searchRotatedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid; // Target found
            }

            // Check if the left half is sorted
            if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // The right half is sorted
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] rotatedArray = { 6, 7, 8, 2, 3, 4, 5 };
        System.out.println("Target 8 = " + searchRotatedArray(rotatedArray, 8) + " (index of 8)");
        System.out.println("Target 9 = " + searchRotatedArray(rotatedArray, 9) + " (6 does not exist)");
    }
}
