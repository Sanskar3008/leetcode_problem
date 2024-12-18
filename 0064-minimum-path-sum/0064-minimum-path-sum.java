class Solution {
    int t[][]=new int[201][201];
    public int minPathSum(int[][] grid) {
            for(int i=0;i<t.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
    
        return solve(grid,grid.length-1,grid[0].length-1);
        
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
}