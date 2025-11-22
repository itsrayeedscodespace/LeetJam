import java.util.HashMap;
/**
 * Finds the single number in an array where every other number appears twice.
 *
 * Approach:
 *   - Use a HashMap to count occurrences of each number.
 *   - Iterate through the array, updating the count for each number.
 *   - After counting, iterate through the array again to find the number
 *     with a count of 1, which is the single number.
 *
 * Time Complexity: O(n)
 *   - Counting occurrences takes O(n)
 *   - Finding the single number also takes O(n)
 *   - Total: O(n)
 *
 * Space Complexity: O(n)
 *   - In the worst case, the HashMap stores a count for every distinct number.
 */
class Problem136Rayeed {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num: nums) {
            if (map.get(num) == 1) return num;
        }
        return -1;
    }
}
