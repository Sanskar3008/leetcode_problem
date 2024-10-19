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
    boolean b=false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
      return   find(root,targetSum,0);
        
        
    }

    public boolean find(TreeNode n,int target,int sum)
    {
        if(n==null)
        return false;
        sum+=n.val;
        if(sum==target &&n.left==null &&n.right==null)
        {
                return true;
        }
        

        
      return find(n.left,target,sum)|| find(n.right,target,sum);
      
    }
}