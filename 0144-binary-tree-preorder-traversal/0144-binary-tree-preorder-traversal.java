class Solution {
    public List preorderTraversal(TreeNode root) {
        List result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode node, List result) {
        if (node == null) {
            return;
        }

        // 1. Visit Root
        result.add(node.val);
        // 2. Visit Left
        dfs(node.left, result);
        // 3. Visit Right
        dfs(node.right, result);
    }
}