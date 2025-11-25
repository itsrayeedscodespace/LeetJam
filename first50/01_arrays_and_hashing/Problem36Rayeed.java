import java.util.HashSet;

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
