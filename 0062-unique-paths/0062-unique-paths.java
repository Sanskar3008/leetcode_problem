class Solution {
    int [][]t=new int[101][101];
    public int uniquePaths(int m, int n) {
        for(int i=0;i<t.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
    
    return solve(m-1,n-1);
        
    }

    public int solve(int m,int n)
    {
        if(m==0 && n==0)
        {

            return 1;
        }

        if(m<0||n<0)
        {
            return 0;
        }

        if(t[m][n]!=-1)
        {
            return t[m][n];
        }

        int l=solve(m-1,n);
        int r=solve(m,n-1);

        return t[m][n]=l+r;
    }
}