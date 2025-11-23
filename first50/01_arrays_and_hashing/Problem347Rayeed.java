import java.util.HashMap;
/**
 * Finds the k most frequent elements in the given array.
 *
 * Approach:
 *   - Use a HashMap to count the frequency of each element in the array.
 *   - Then, repeatedly find and remove the element with the highest frequency
 *     from the map, adding it to the result list until k elements have been found.
 *
 * Time Complexity: O(n * k)
 *   - Counting frequencies takes O(n).
 *   - Finding the max frequency element k times takes O(n) each time,
 *     leading to O(n * k) in total.
 *
 * Space Complexity: O(n)
 *   - The HashMap stores a count for each distinct number in the array.
 */
public class Problem347Rayeed {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freqList = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (k != 0) {
            int i = 0;
            int max1 = Integer.MIN_VALUE;
            int placeholder = 0;
            while (i < nums.length) {
                if (map.getOrDefault(nums[i], 0) > max1) {
                    placeholder = nums[i];
                    max1 = map.getOrDefault(nums[i], 0);
                }
                i++;
            }
            int mapping = map.remove(placeholder);
            freqList[k-1] = placeholder;
            k--;
        }
        return freqList;
    }
}
