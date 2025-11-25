import java.util.ArrayList;
import java.util.List;
/**
 * Finds all numbers in the range [1, n] that are missing from the input array.
 *
 * DETAILED DESCRIPTION:
 * ---------------------
 * Given an array of integers where each integer is in the range [1, n] (n = size of array),
 * some numbers may appear twice while others may be missing. The task is to find all
 * numbers in the range [1, n] that do not appear in the array.
 *
 * This solution uses an auxiliary ArrayList to track which numbers are present.
 * It initializes a list of size n+1 (to use 1-based indexing) with 0s, then marks
 * indices corresponding to numbers found in the input array. Finally, it collects
 * indices that remain 0, indicating those numbers are missing.
 *
 * HOW THE METHOD WORKS:
 * 1. Create an ArrayList `missingIndices` of size n+1, initialized with 0s.
 *    - Index i represents whether number i is present in the input array.
 *
 * 2. Iterate through each number in the input array `nums`:
 *    - For each number `num`, set `missingIndices[num]` to 1 to mark it as present.
 *
 * 3. After processing all numbers, iterate through `missingIndices` from index 1 to n:
 *    - If `missingIndices[i]` is still 0, it means number i is missing from the input.
 *    - Add i to the result list `missingValues`.
 *
 * 4. Return the list of missing values.
 *
 * TIME COMPLEXITY: O(n)
 *   - Initializing the list takes O(n).
 *   - Marking presence for each number takes O(n).
 *   - Collecting missing numbers takes O(n).
 *
 * SPACE COMPLEXITY: O(n)
 *   - The auxiliary list `missingIndices` uses O(n) space.
 */
public class Problem448Rayeed {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> missingValues = new ArrayList<>();
        ArrayList<Integer> missingIndices = new ArrayList<>(nums.length+1);
        missingIndices.add(1);
        for (int i = 1; i <= nums.length; i++) {
            missingIndices.add(0);
        }
        for (int i = 0; i < nums.length; i++) {
            missingIndices.set(nums[i], 1);
        }
        for (int i = 1; i < missingIndices.size(); i++) {
            if (missingIndices.get(i) == 0) {
                missingValues.add(i);
            }
        }
        return missingValues;
    }
}
