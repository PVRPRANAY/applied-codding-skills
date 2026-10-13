class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return maxDiameter;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);

        // Update the maximum diameter found so far
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // Return the depth of the subtree rooted at this node
        return 1 + Math.max(leftDepth, rightDepth);
    }
}