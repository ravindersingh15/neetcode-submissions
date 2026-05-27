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
    TreeNode ret;
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if(root == null) {
            return false;
        }
        // calling recursion
        boolean leftAns = dfs(root.left, p, q);
        boolean rightAns = dfs(root.right, p, q);
        boolean currAns = (root.val == p.val || root.val == q.val);
        int count = (leftAns ? 1 : 0) + (rightAns ? 1 : 0) + (currAns ? 1 : 0);
        if(count > 1) {
            ret = root;
        }
        if(count > 0)
            return true;
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // easy using recursion
        ret = new TreeNode();
        dfs(root, p, q);
        return ret;
    }
}