import java.util.HashSet;
/**
 * VALID SUDOKU CHECKER
 * ====================
 *
 * PROBLEM:
 * --------
 * Determine if a 9×9 Sudoku board is valid according to these rules:
 * 1. Each row must contain digits 1-9 without repetition
 * 2. Each column must contain digits 1-9 without repetition
 * 3. Each of the nine 3×3 sub-boxes must contain digits 1-9 without repetition
 *
 * Note:
 * - Only filled cells (digits 1-9) need validation
 * - Empty cells are represented by '.'
 * - Board doesn't need to be solvable, just currently valid
 *
 *
 * APPROACH:
 * ---------
 * We use THREE arrays of HashSets to track which numbers we've seen:
 * 1. rows[9]  - One HashSet for each of the 9 rows
 * 2. cols[9]  - One HashSet for each of the 9 columns
 * 3. boxes[9] - One HashSet for each of the 9 (3×3) boxes
 *
 * As we scan through each cell:
 * - Skip empty cells ('.')
 * - For filled cells, check if the number already exists in its row, column, or box
 * - If duplicate found → return false (invalid)
 * - If no duplicate → add the number to all three corresponding HashSets
 * - If we complete the scan without finding duplicates → return true (valid)
 *
 *
 * WHY HASHSET?
 * ------------
 * HashSet is perfect for this problem because:
 * 1. Automatically prevents duplicates (can't add same element twice)
 * 2. contains() operation is O(1) - instant lookup
 * 3. add() operation is O(1) - instant insertion
 * 4. Clean, readable code
 * 5. Built-in duplicate detection without manual checking
 *
 * Alternative approaches and why they're worse:
 * - Nested loops: O(n²) for each check = O(729) total → TOO SLOW
 * - Sorting: O(n log n) and modifies data → UNNECESSARY
 * - Boolean array: Works but less intuitive than HashSet
 *
 *
 * BOX INDEX CALCULATION:
 * ----------------------
 * The 9 boxes are numbered 0-8 like this:
 *
 *   Columns: 0-2    3-5    6-8
 *          ┌──────┬──────┬──────┐
 *   Rows   │  0   │  1   │  2   │  (row/3 = 0)
 *   0-2    ├──────┼──────┼──────┤
 *          │  3   │  4   │  5   │  (row/3 = 1)
 *   3-5    ├──────┼──────┼──────┤
 *          │  6   │  7   │  8   │  (row/3 = 2)
 *   6-8    └──────┴──────┴──────┘
 *        (col/3=0)(col/3=1)(col/3=2)
 *
 * Formula: boxIndex = (row / 3) * 3 + (col / 3)
 *
 * How it works:
 * - row / 3: Determines which horizontal group of boxes (0, 1, or 2)
 * - col / 3: Determines which vertical group of boxes (0, 1, or 2)
 * - Multiply row group by 3, add column group
 *
 * Examples:
 * - Cell (0, 0): box = (0/3)*3 + (0/3) = 0*3 + 0 = 0 (top-left)
 * - Cell (5, 7): box = (5/3)*3 + (7/3) = 1*3 + 2 = 5 (middle-right)
 * - Cell (8, 8): box = (8/3)*3 + (8/3) = 2*3 + 2 = 8 (bottom-right)
 *
 *
 * TIME COMPLEXITY: O(1) or O(81)
 * -------------------------------
 * - We iterate through all 9×9 = 81 cells exactly once
 * - For each cell:
 *   • Skip operation if empty: O(1)
 *   • Calculate box index: O(1) - simple arithmetic
 *   • Check 3 HashSets with contains(): O(1) × 3 = O(1)
 *   • Add to 3 HashSets: O(1) × 3 = O(1)
 * - Total: 81 cells × O(1) per cell = O(81)
 * - Since board size is fixed (always 9×9), this is technically O(1) constant time
 *
 * Breakdown:
 * - Initialization of 27 HashSets: O(27) = O(1)
 * - Main double loop: O(9) × O(9) = O(81) = O(1)
 * - HashSet operations: O(1) average case for add/contains
 *
 *
 * SPACE COMPLEXITY: O(1) or O(81)
 * --------------------------------
 **/
public class Problem36Rayeed {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char element = board[i][j];

                if (element == '.') {
                    continue;
                }

                int boxIdx = (i / 3) * 3 + (j / 3);

                if (rows[i].contains(element) || cols[j].contains(element) || boxes[boxIdx].contains(element)) {
                    return false;
                }

                rows[i].add(element);
                cols[j].add(element);
                boxes[boxIdx].add(element);
            }
        }
        return true;
    }
}
