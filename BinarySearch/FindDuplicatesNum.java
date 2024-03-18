package BinarySearch;

/**
 * FindDuplicatesNum
 */
public class FindDuplicatesNum {

    /**
     * 
     * @param arr
     * @param target
     * @param searchFirst used to distinguish between finding the first occurrence
     *                    and the last occurrence of the target element
     * @return
     */
    public static int binarySearch(int[] arr, int target, boolean searchFirst) {
        int start = 0, end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                result = mid;
                // Depending on searchFirst, either move the end or the start
                if (searchFirst) {
                    end = mid - 1; // Continue searching in the left half
                } else {
                    start = mid + 1; // Continue searching in the right half
                }
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static int counter(int[] arr, int target) {
        // Find the index of the first occurrence of the target
        int firstIndex = binarySearch(arr, target, true);
        if (firstIndex == -1)
            return 0;

        // Find the index of the last occurrence of the target
        int lastIndex = binarySearch(arr, target, false);
        return lastIndex - firstIndex + 1;
    }

    public static void main(String[] args) {
        int[] array = { 2, 2, 3, 3, 4, 4, 4, 8, 8, 8, 8, 8, 9, 9, 10, 12, 15 };
        System.out.println("Target 4 = " + counter(array, 4) + " Occurrences");
        System.out.println("Target 2 = " + counter(array, 2) + " Occurrences");
        System.out.println("Target 5 = " + counter(array, 5) + " Occurrences");
    }

}