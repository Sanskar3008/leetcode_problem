class Solution {
    int t[][]=new int[201][201];
    public int minPathSum(int[][] grid) {
            for(int i=0;i<t.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
    
        //return solve(grid,grid.length-1,grid[0].length-1);
        return solve2(grid);
        
    }
      public int solve(int [][]arr,int i,int j)
    {
        if(i==0&& j==0)
        {
            return arr[0][0];
        }

        if(i<0||j<0)
        {
            return Integer.MAX_VALUE-5000;
        }
        if(t[i][j]!=-1)
        {
           return t[i][j];
        }

        int l=arr[i][j]+solve(arr,i-1,j);
        int r=arr[i][j]+solve(arr,i,j-1);

        return t[i][j]=Math.min(l,r);

    }

    public int solve2(int [][]arr)
    {
        int m = arr.length; // Number of rows
    int n = arr[0].length; // Number of columns

    int[][] dp = new int[m][n]; // Initialize DP table with the same size as arr

    // Iterate through the grid
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0) {
                // Starting cell
                dp[i][j] = arr[i][j];
            } else {
                // Minimum path sum from the top or left
                int fromTop = (i > 0) ? dp[i - 1][j] : Integer.MAX_VALUE;
                int fromLeft = (j > 0) ? dp[i][j - 1] : Integer.MAX_VALUE;
                dp[i][j] = arr[i][j] + Math.min(fromTop, fromLeft);
            }
        }
    }

    // The bottom-right cell contains the minimum path sum
    return dp[m - 1][n - 1];
        
    }
}