class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
     

        for(int i=0;i<nums.length;i++)
        {
            total+=nums[i];
        }
        if(total%2!=0)
        return false;
           int [][]t=new int[nums.length][total/2+1];
           
        for(int i=0;i<t.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
        return solve(nums,nums.length-1,total/2,0,t);
    }

    public boolean solve(int []nums,int i,int tar ,int cur,int [][]t)
    {
        if(cur==tar)
        {
            return true;
        }

        if(i==0)
        {
            return tar==nums[0];
        }

        if(t[i][cur]!=-1)
        {
            return t[i][cur]==1?true:false;
        }

        boolean nt=solve(nums,i-1,tar,cur,t);
      boolean ta=false;
        if(cur+nums[i]<=tar)
        {
            ta=solve(nums,i-1,tar,cur+nums[i],t);
        }
  t[i][cur]=nt||ta?1:0;
        return nt||ta;
        
    }
}