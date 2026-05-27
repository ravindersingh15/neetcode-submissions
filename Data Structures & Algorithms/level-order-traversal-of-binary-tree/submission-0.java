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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // base case
        if(root == null)
            return new ArrayList<>();
        // using simple bfs
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            int sz = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < sz; i++) {
                TreeNode top = q.poll();
                if(top.left != null)    q.add(top.left);
                if(top.right != null)   q.add(top.right);
                temp.add(top.val);
            }
            ret.add(temp);
        }
        return ret;
    }
}
