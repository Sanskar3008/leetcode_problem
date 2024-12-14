class Solution {
    int t[]=new int[101];
    public int rob(int[] nums) {
        
        
            Arrays.fill(t,-1);
            return bottomup(nums);
        
       // return solve(nums,nums.length-1);
        
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
    public int bottomup(int []nums)
    {
        int []dp=new int [nums.length+1];

        dp[0]=nums[0];

        for(int i=1;i<nums.length;i++)
        {
           int l=Integer.MIN_VALUE ;

           if(i==1)
           {
            l=nums[i];
           }
           else
           {
            l=nums[i]+dp[i-2];
           }

          int r=dp[i-1];
           dp[i]=Math.max(l,r);
        }
        return dp[nums.length-1];
    }
}