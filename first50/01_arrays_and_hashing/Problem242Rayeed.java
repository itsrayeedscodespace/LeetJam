import java.util.HashMap;
/**
 * Determines whether two strings s and t are anagrams.
 * This implementation builds two separate HashMaps (map1 and map2),
 * each storing the frequency of every character in the corresponding string.
 *
 * For each index i, the code:
 *   - Adds the character from s to map1 (initializing if missing, then incrementing)
 *   - Adds the character from t to map2 (same process)
 * After the loop, it compares both maps. If they are equal,
 * the frequency counts match and the strings are anagrams.
 *
 * Time Complexity: O(n)
 *   - One loop through both strings, and map operations are O(1) on average.
 *   - The final map comparison is O(k) where k = number of unique characters,
 *     which is at most 26 for lowercase letters, so effectively constant.
 *
 * Space Complexity: O(k)
 *   - Two HashMaps storing character frequencies.
 *   - k is the number of unique characters. If limited to lowercase letters,
 *     this is O(1). Otherwise, O(k).
 */
public class Problem242Rayeed {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!(map1.containsKey(s.charAt(i)))) {
                map1.put(s.charAt(i), 1);
            }
            if (!(map2.containsKey(t.charAt(i)))) {
                map2.put(t.charAt(i), 1);
            }
            if (map1.containsKey(s.charAt(i))) {
                map1.replace(s.charAt(i), map1.get(s.charAt(i)) + 1);
            }
            if (map2.containsKey(t.charAt(i))) {
                map2.replace(t.charAt(i), map2.get(t.charAt(i)) + 1);
            }
        }
        if (map1.equals(map2)) {
            return true;
        }
        return false;
    }
}
