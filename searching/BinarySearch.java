// Algorithm: Binary Search
// Time Complexity: O(log n)
// Space Complexity: O(1)
// Key Idea: Search on a sorted array by repeatedly halving the search space

package searching;

public class BinarySearch {

    // Iterative binary search
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // key not found
    }
}
