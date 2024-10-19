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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        find(root,0);
        return sum;
    }
    public void find(TreeNode n,int cur)
    {
        if(n==null)
        {
            return;
        }
        if(n.left==null&& n.right==null)
        {
            cur=cur*10+n.val;
            sum+=cur;
           
        }
        find(n.left,cur*10+n.val);
        find(n.right,cur*10+n.val);
    }
}