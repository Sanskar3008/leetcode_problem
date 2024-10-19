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
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        find(root);
        return ans-1;
    }
    public int find(TreeNode n)
    {
        if(n==null)
        {
            return 0 ;
        }

        int l=find(n.left);
        int r=find(n.right);
        ans=Math.max(l+r+1,ans);

        return Math.max(l,r)+1;
    }
}