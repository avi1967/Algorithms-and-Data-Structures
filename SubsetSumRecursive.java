// Algorithm: Subset Sum (Recursive Backtracking)
// Time Complexity: O(2^n) in the worst case
// Space Complexity: O(n) recursion stack
// Key Idea: Explore all subsets by including or excluding each element
//
// Notes:
// - Subset Sum is a canonical NP-complete problem.
// - This implementation demonstrates exponential-time behavior
//   and recursive decision branching, not optimization or DP.

package np_complete;

public class SubsetSumRecursive {

    /**
     * Determines whether there exists a subset of the first n elements
     * of the given set that sums to the target value.
     *
     * @param set   array of non-negative integers
     * @param n     number of elements considered
     * @param sum   target sum
     * @return      true if a subset exists, false otherwise
     */
    public static boolean isSubsetSum(int[] set, int n, int sum) {

        // Base case: target sum achieved
        if (sum == 0) {
            return true;
        }

        // Base case: no elements left but sum not achieved
        if (n == 0) {
            return false;
        }

        // If last element is greater than remaining sum, exclude it
        if (set[n - 1] > sum) {
            return isSubsetSum(set, n - 1, sum);
        }

        // Recursive choice:
        // 1. Exclude the last element
        // 2. Include the last element
        return isSubsetSum(set, n - 1, sum)
            || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }
}
