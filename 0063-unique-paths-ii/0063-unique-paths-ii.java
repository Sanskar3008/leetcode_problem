class Solution {
    int t[][]=new int[101][101];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
          for(int i=0;i<t.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
        
        return  solve(obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1);
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
}