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
    public List<Integer> rightSideView(TreeNode root) {
        // base case
        if(root == null)
            return new ArrayList<>();
        // using simple bfs
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i = 0; i < sz - 1; i++) {
                TreeNode top = q.poll();
                if(top.left != null)    q.add(top.left);
                if(top.right != null)   q.add(top.right);
            }
            TreeNode top = q.poll();
            if(top.left != null)    q.add(top.left);
            if(top.right != null)   q.add(top.right);
            ret.add(top.val);
        }
        return ret;
    }
}
