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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double>l=new ArrayList<>();
        if(root==null)
        return l;
        Queue <TreeNode>q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size=q.size();
             double csum=0;
            for(int i=0;i<size;i++)
            {
                TreeNode n=q.poll();
               csum+=n.val;

               if(n.left!=null)
                q.add(n.left);

                if(n.right!=null)
                q.add(n.right);
                
            }
            l.add(csum/size);
        } 

        return l;
    }
}