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
    int ret;
    public void dfs(TreeNode root, int mx) {
        // base case
        if(root == null) {
            return;
        }
        // calling recursion
        if(root.left != null) {
            dfs(root.left, Math.max(mx, root.val));
        }
        if(root.right != null) {
            dfs(root.right, Math.max(mx, root.val));
        }
        ret += root.val >= mx ? 1 : 0;
    }
    public int goodNodes(TreeNode root) {
        // easy using dfs
        ret = 0;
        dfs(root, -101);
        return ret;
    }
}
