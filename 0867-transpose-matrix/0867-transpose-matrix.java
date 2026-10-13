class Solution {
    public int[][] transpose(int[][] matrix) {
        // Get original dimensions
        int R = matrix.length;
        int C = matrix[0].length;
        
        // Create new matrix with flipped dimensions (C x R)
        int[][] ans = new int[C][R];
        
        // Fill the new matrix
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                ans[c][r] = matrix[r][c];
            }
        }
        
        return ans;
    }
}
