/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    List<TreeNode> nodes;
    private void dfs(TreeNode root) {
        // base case
        if(root == null)
            return;
        // calling recursion
        if(root.left != null) {
            dfs(root.left);
        }
        nodes.add(root);
        if(root.right != null) {
            dfs(root.right);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        // using inorder traversal - form an array
        nodes = new ArrayList<TreeNode>();
        dfs(root);
        return nodes.get(k - 1).val;
    }
}
