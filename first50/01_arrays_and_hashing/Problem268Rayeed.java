/**
 * Finds the missing number in an array containing distinct values
 * from 0 to n, with exactly one number missing.
 *
 * Approach:
 *   - Create an ArrayList `mapper` of size n+1, initialized with all 0s.
 *     Each index represents a number from 0 to n.
 *   - For each number in nums, mark its index in `mapper` as 1.
 *     This indicates that the number exists in the input.
 *   - After marking all numbers, the index that still contains 0
 *     corresponds to the missing number.
 *
 * Example:
 *   nums: [3, 0, 1]
 *   mapper (after marking): [1,1,0,1]
 *   First 0 appears at index 2 → missing number = 2
 *
 * Time Complexity: O(n)
 *   - Initializing the list takes O(n)
 *   - Marking numbers takes O(n)
 *   - Searching for the missing index using indexOf takes O(n)
 *
 * Space Complexity: O(n)
 *   - The mapper list stores n+1 entries
 */
import java.util.ArrayList;


public class Problem268Rayeed {
    public int missingNumber(int[] nums) {
        ArrayList<Integer> mapper = new ArrayList<>(nums.length+1);
        for (int i = 0; i <= nums.length; i++) {
            mapper.add(0);
        }
        for (int i = 0; i < nums.length; i++) {
            mapper.set(nums[i], 1);
        }
        return mapper.indexOf(0);
    }
}