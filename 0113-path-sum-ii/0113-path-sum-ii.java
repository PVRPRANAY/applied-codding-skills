import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, targetSum, currentPath, result);
        return result;
    }
    
    private void findPaths(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        
        // Add current node to the path
        currentPath.add(node.val);
        
        // Check if it's a leaf node and the path sum matches targetSum
        if (node.left == null && node.right == null && node.val == remainingSum) {
            result.add(new ArrayList<>(currentPath)); // Create a new copy of the current path
        } else {
            // Continue exploring left and right subtrees
            findPaths(node.left, remainingSum - node.val, currentPath, result);
            findPaths(node.right, remainingSum - node.val, currentPath, result);
        }
        
        // Remove the current node from the path to backtrack
        currentPath.remove(currentPath.size() - 1);
    }
}
