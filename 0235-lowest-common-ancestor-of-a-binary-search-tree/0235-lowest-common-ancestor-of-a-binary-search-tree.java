/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        root=find(root,p.val,q.val);
        return root;
    }
    public TreeNode find(TreeNode n,int p,int q)
    {

        if(n==null||n.val==p||n.val==q)
        return n;

       TreeNode l= find(n.left,p,q);
        TreeNode r= find(n.right,p,q);

        if(l==null)
        {
            return r;
        }
        else if(r==null){
            return l;
        }
       
        
            return n;
        
    }
}