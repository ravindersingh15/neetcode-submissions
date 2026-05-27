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
    int count, ret, k;
    private void dfs(TreeNode root) {
        // base case
        if(root == null)
            return;
        // calling recursion
        if(root.left != null) {
            dfs(root.left);
        }
        count++;
        if(count == k) {
            ret = root.val;
        }
        if(root.right != null) {
            dfs(root.right);
        }
    }
    public int kthSmallest(TreeNode root, int K) {
        // using inorder traversal
        k = K;
        count = 0;
        ret = 0;
        dfs(root);
        return ret;
    }
}
