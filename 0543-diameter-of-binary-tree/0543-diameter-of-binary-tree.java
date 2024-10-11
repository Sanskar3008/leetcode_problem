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
    int dia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        find(root);

        return dia-1;
    }

    public int find(TreeNode n)
    {
        if(n==null)
        return 0;
        int l=find(n.left);
        int r=find(n.right);

        int d=l+r+1;
        dia=Math.max(dia,d);

        return Math.max(l,r)+1;        
    }
}