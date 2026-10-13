class Solution {
    public int maxDepth(TreeNode root) {
        // Base case: if the tree is empty, its depth is 0
        if (root == null) {
            return 0;
        }
        
        // Recursively find the depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // The maximum depth is the max between left and right subtrees + 1 (for the current node)
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
