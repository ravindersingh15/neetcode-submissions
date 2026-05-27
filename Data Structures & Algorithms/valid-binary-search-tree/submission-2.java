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
public class Pair {
    int min, max;
    Pair() {
        this.min = (int)1e9;
        this.max = (int)-1e9;
    }
    Pair(int val) {
        this.min = val;
        this.max = val;
    }
    Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }
    Pair add(Pair x) {
        this.min = Math.min(x.min, this.min);
        this.max = Math.max(x.max, this.max);
        return this;
    }
}
class Solution {
    Boolean ans;
    private Pair dfs(TreeNode root) {
        // base case
        if(root.left == null && root.right == null) {
            return new Pair(root.val);
        }
        // calling recursion
        Pair leftP , rightP;
        Pair ret = new Pair(root.val);
        if(root.left != null) {
            leftP = dfs(root.left);
            if(root.val <= leftP.max) {
                ans = false;
                return new Pair();
            }
            ret.add(leftP);
        }
        if(root.right != null) {
            rightP = dfs(root.right);
            if(root.val >= rightP.min) {
                ans = false;
                return new Pair();
            }
            ret.add(rightP);
        }
        return ret;
    }
    public boolean isValidBST(TreeNode root) {
        ans = true;
        dfs(root);
        return ans;
    }
}
