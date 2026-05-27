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
    Map<Integer, Integer> f;
    private TreeNode construct(int[] preorder, int[] inorder, int i, int l, int r) {
        // base case
        if(l > r) {
            return null;
        }
        // calling recursion
        TreeNode ret = new TreeNode(preorder[i]);
        TreeNode leftNode = null;
        TreeNode rightNode = null;
        int idx = f.get(preorder[i]);
        if(l < idx) {
            leftNode = construct(preorder, inorder, i + 1, l, idx - 1);
        }
        if(r > idx) {
            rightNode = construct(preorder, inorder, i + (idx - l) + 1, idx + 1, r);
        }
        ret.left = leftNode;
        ret.right = rightNode;
        return ret;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // using recursion
        // constructing tree for each index of preorder and range of inorder
        f = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            f.put(inorder[i], i);
        }
        return construct(preorder, inorder, 0, 0, inorder.length - 1);
    }
}
