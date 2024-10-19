class Solution {
    int ans = 0;
    int cnt = 0;  // Move cnt as a class-level variable
    
    public int kthSmallest(TreeNode root, int k) {
        find(root, k);
        return ans;
    }
    
    public void find(TreeNode n, int k) {
        if (n == null) return;
        
        // Traverse the left subtree first
        find(n.left, k);
        
        // Increment count for each visited node
        cnt++;
        
        // If the count equals k, we have found the kth smallest element
        if (cnt == k) {
            ans = n.val;
            return;
        }
        
        // Traverse the right subtree
        find(n.right, k);
    }
}
