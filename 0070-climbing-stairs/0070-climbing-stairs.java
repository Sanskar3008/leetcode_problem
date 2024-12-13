class Solution {
    int []t=new int[47];
    public int climbStairs(int n) {
        Arrays.fill(t,-1);
        return solve(n);
    }
        
    
      public int solve(int n) {
        if(n==0||n==1)
        {
            return 1;
        }
        if(t[n]!=-1)
        {
            return t[n];
        }
        int l=solve(n-1);
        int r=solve(n-2);

        return t[n]= l+r;
        
    }

}