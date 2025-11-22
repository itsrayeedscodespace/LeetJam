/**
 * This method finds two indices i and j such that nums[i] + nums[j] == target.
 * It uses a nested loop: the outer loop moves from the start of the array,
 * and the inner loop checks elements from the end toward i.
 * As soon as a matching pair is found, the indices are stored and the inner loop breaks.
 *
 * Time Complexity: O(n²)
 *   - Because for each element i, the algorithm may scan almost the entire rest of the array (j loop).
 *
 * Space Complexity: O(1)
 *   - Only a fixed-size array of two integers is used, regardless of input size.
 */

class Problem1Rayeed {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    break;
                }
            }
        }
        return indices;
    }
}