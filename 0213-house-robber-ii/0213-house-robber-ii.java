class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        int[] temp1=new int [nums.length];
        int []temp2=new int [nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
            {
                temp1[i]=0;
            }
            else
            {
                temp1[i]=nums[i];
            }

            if(i==nums.length-1)
            {
                temp2[i]=0;
            }
            else
            {
                temp2[i]=nums[i];
            }
        }
        return Math.max(bottomup(temp1),bottomup(temp2));
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