class Solution {
    int t[]=new int[101];
    public int rob(int[] nums) {
        
        
            Arrays.fill(t,-1);
        
        return solve(nums,nums.length-1);
        
    }
    public int solve(int []nums ,int n)
    {
        if(n==0)
        {
            return nums[0];
        }

        if(n<0)
        {
            return 0;
        }
        if(t[n]!=-1)
        {
            return t[n];
        }

        int l=nums[n]+solve(nums,n-2);
        int r=solve(nums,n-1);

        return t[n]= Math.max(l,r);

    }
}