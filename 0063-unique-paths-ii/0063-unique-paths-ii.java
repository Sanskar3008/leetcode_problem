class Solution {
    int t[][]=new int[101][101];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
          for(int i=0;i<t.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
        
       // return  solve(obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1);
        return bottomup(obstacleGrid);

    }

    public int solve(int [][]arr,int i,int j)
    {
        if(i==0&& j==0&&arr[i][j]!=1)
        {
            return 1;
        }

        if(i<0||j<0||arr[i][j]==1)
        {
            return 0;
        }
        if(t[i][j]!=-1)
        {
           return t[i][j];
        }

        int l=solve(arr,i-1,j);
        int r=solve(arr,i,j-1);

        return t[i][j]=l+r;

    }

    public int bottomup(int arr[][])
    {
        int dp[][]=new int[arr.length+1][arr[0].length+1];

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]==1)
                {
                    dp[i][j]=0;
                    continue;
                }
                if(i==0&&j==0)
                {
                    dp[i][j]=1;
                    continue;
                }
           int l=0;
           int r=0;
                if(i>0 &&dp[i][j]!=1)
                {
                   l=dp[i-1][j];
                }

                
                if(j>0 &&dp[i][j]!=1)
                {
                   r=dp[i][j-1];
                }
               dp[i][j]=l+r;
            }
        }

       return dp[arr.length-1][arr[0].length-1];
    }
}