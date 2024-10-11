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
    public TreeNode invertTree(TreeNode root) {
        TreeNode ans=find(root);
        return ans;
    }

    public TreeNode find(TreeNode n)
    {
        if(n==null)
        return null;

        TreeNode l=find(n.left);
        TreeNode r=find(n.right);

        n.left=r;
        n.right=l;

        return n;
    }
}