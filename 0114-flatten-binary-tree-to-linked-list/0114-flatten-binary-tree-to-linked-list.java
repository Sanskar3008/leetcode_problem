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
    public void flatten(TreeNode root) {
        find(root);
    }
 public void find(TreeNode n)
 {
    if(n==null)
    {
        return;
    }
    
    TreeNode temp=n.left;
   if(temp!=null)
   {
    while(temp.right!=null)
    {
       temp=temp.right;
    }
   }
    if(temp!=null)
   { temp.right=n.right;
    n.right=n.left;
    n.left=null;
   }
    find(n.right);
     
  }
}