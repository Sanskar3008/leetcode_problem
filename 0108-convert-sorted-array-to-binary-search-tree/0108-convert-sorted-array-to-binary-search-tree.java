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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=find(nums,0,nums.length-1);
        return root;
    }

    public TreeNode find(int []nums,int l,int r)
    {
        if(l>r)
        return null;


        int m=l+(r-l)/2;
        TreeNode n=new TreeNode(nums[m]);

        n.left=find(nums,l,m-1);
        n.right=find(nums,m+1,r);

        return n;
    }


}