/**
 * Checks whether the given array contains any duplicate values.
 * It uses a HashMap to track which numbers have been seen already.
 * As the loop iterates, if a number is already in the map, a duplicate
 * is found and the method returns true immediately. Otherwise, the
 * number is added to the map. If the loop completes, there were no duplicates.
 *
 * Time Complexity: O(n)
 *   - Each element is processed once and HashMap operations (containsKey, put)
 *     run in average O(1) time.
 *
 * Space Complexity: O(n)
 *   - In the worst case (no duplicates), the HashMap stores all elements.
 */
import java.util.HashMap;
class Problem217Rayeed {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }
}