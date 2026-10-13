class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Pruning 1: Length check
        if (word.length() > m * n) {
            return false;
        }

        // Pruning 2: Character frequency check
        int[] boardCounts = new int[128];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boardCounts[board[i][j]]++;
            }
        }
        for (char c : word.toCharArray()) {
            if (--boardCounts[c] < 0) {
                return false;
            }
        }

        // Pruning 3: Reverse word if start character is more frequent than end character
        // Helps avoid long invalid paths (e.g., boards filled with 'A's ending in 'B')
        if (boardCounts[word.charAt(0)] > boardCounts[word.charAt(word.length() - 1)]) {
            word = new StringBuilder(word).reverse().toString();
        }

        // Search for the word starting from each cell
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // Base case: All characters matched
        if (index == word.length()) {
            return true;
        }

        // Boundary checks and character match check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark cell as visited by temporarily modifying it
        char temp = board[r][c];
        board[r][c] = '#';

        // Explore adjacent directions: Up, Down, Left, Right
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);

        // Backtrack: Restore original character
        board[r][c] = temp;

        return found;
    }
}