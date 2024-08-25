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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
          List<List<Integer>>l=new ArrayList<>();

        if(root==null)
        return l;
        
     Deque<TreeNode>q=new ArrayDeque<>();
      
        q.addFirst(root);
        boolean b=false;

        while(!q.isEmpty())
        {
            List<Integer>c=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                if(!b)
                {
                    TreeNode n=q.removeFirst();
                    c.add(n.val);

                    if(n.left!=null)
                    {
                        q.addLast(n.left);
                    }
                     if(n.right!=null)
                    {
                        q.addLast(n.right);
                    }
                }
                else
                {
                     TreeNode n=q.removeLast();
                    c.add(n.val);

                    if(n.right!=null)
                    {
                        q.addFirst(n.right);
                    }
                     if(n.left!=null)
                    {
                        q.addFirst(n.left);
                    }
                }
            }
            b=!b;
            l.add(c);
        }

        return l;
    }
}