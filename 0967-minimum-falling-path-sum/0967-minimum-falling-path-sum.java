class Solution {
    int t[][]=new int[101][101];
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<t.length;i++)
        {
            Arrays.fill(t[i],-1);
        }

        // for(int i=0;i<n;i++)
        // {
        //     min=Math.min(min,solve(matrix,m-1,i));
        // }
        // return min;

        return solve2(matrix);

        
    }

    public int  solve(int[][] arr,int i,int j)
    {
        if(i==0 &&j>=0 &&j<arr[0].length)
        {
            return arr[i][j];
        }

        if(i<0 || j<0||j>=arr[0].length)
        {
            return Integer.MAX_VALUE-5000;
        }
        if(t[i][j]!=-1)
        {
            return t[i][j];
        }
        int l=arr[i][j]+solve(arr,i-1,j);
        int m=arr[i][j]+solve(arr,i-1,j-1);
        int r=arr[i][j]+solve(arr,i-1,j+1);

        int min=Math.min(l,r);

        return t[i][j]= Math.min(min,m);
    }

    public int solve2(int [][]arr)
    {
        int [][] dp=new int[arr.length][arr[0].length];

        for(int j=0;j<arr[0].length;j++)
        {
            dp[0][j]=arr[0][j];
        }

        for(int i=1;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                int l=arr[i][j]+dp[i-1][j];
                int m=0;
                if(j+1>=arr[0].length)
                {
                    m=Integer.MAX_VALUE;
                }
                else
                {
                    m=arr[i][j]+dp[i-1][j+1];
                }

                 int r=0;
                if(j-1<0)
                {
                    r=Integer.MAX_VALUE;
                }
                else
                {
                    r=arr[i][j]+dp[i-1][j-1];
                }
                dp[i][j]=Math.min(m,Math.min(l,r));

            }
        }
        int ans=Integer.MAX_VALUE;

        for(int j=0;j<arr[0].length;j++)
        {
            ans=Math.min(ans,dp[arr.length-1][j]);

        }
        return ans;
    }
}