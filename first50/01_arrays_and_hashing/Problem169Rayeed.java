import java.util.HashMap;
/**
 * Finds the majority element in the array.
 *
 * A "majority element" is the value that appears more than n/2 times
 * in the array, where n is the array length. Because such an element
 * is guaranteed to exist (based on the usual problem constraints),
 * this method returns that value.
 *
 * APPROACH:
 * ---------
 * 1. Use a HashMap<Integer, Integer> to count how many times each
 *    number appears in the array.
 *       - For each number, increment its frequency using getOrDefault.
 *
 * 2. Loop through the array again and check which number has a count
 *    greater than n/2 in the map.
 *       - The first number that satisfies this condition is the majority element.
 *
 * 3. If somehow no value meets the requirement (should not happen in
 *    the standard majority-element problem), return -1 as a fallback.
 *
 * TIME COMPLEXITY: O(n)
 *   - Counting all elements takes O(n)
 *   - Checking for majority also takes O(n)
 *
 * SPACE COMPLEXITY: O(n)
 *   - In the worst case, the HashMap stores a count for every distinct number.
 */
public class Problem169Rayeed {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int num: nums) {
            if (map.get(num) > nums.length/2) {
                return num;
            }
        }
        return -1;
    }
}
