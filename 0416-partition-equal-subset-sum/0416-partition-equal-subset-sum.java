class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
     

        for(int i=0;i<nums.length;i++)
        {
            total+=nums[i];
        }
           int [][]t=new int[nums.length][total+1];
           
        for(int i=0;i<t.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
        return solve(nums,nums.length-1,total,0,t);
    }

    public boolean solve(int []nums,int i,int total,int cur,int [][]t )
    {
        if(total-cur==cur)
        {
            return true;
        }

        if(i==0)
        { cur+=nums[0];
            return (cur)==(total-cur);
        }

        if(t[i][cur]!=-1)
        {
            return t[i][cur]==1?true:false;
        }

        boolean nt=solve(nums,i-1,total,cur,t);

        boolean ta=false;

        if(nums[i]+cur<=total-(nums[i]+cur))
        {
            ta=solve(nums,i-1,total,cur+nums[i],t);
        }

      t[i][cur]=  nt||ta?1:0;

        return nt||ta;
    }
}