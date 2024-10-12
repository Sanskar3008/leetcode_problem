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
    List<TreeNode>l=new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root==null)
        return;
        preorder(root);

        root=l.get(0);

        for(int i=1;i<l.size();i++)
        {
          l.get(i-1).left=null;
          l.get(i-1).right=l.get(i);
        }
        
    }

    public void preorder(TreeNode n)
    {
        if(n==null)
        return ;

        l.add(n);
        preorder(n.left);
        preorder(n.right);

    }
}