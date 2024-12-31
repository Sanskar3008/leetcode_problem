class Solution {
    int t[][]=new int [201][201];
    public int minimumTotal(List<List<Integer>> triangle) {

        for(int i=0;i<t.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
        // int min=Integer.MAX_VALUE;
        // for(int i=0;i<triangle.get(triangle.size()-1).size();i++)
        // {
        // min=Math.min(min,solve(triangle,triangle.size()-1,i));
        // }
       // return min;
      //  return solve2(triangle);
      // return solve3(triangle,0,0);
        return solve4(triangle);
        
    }
    public int solve(List<List<Integer>>arr,int i,int j)
    {
        if(i==0&& j==0)
        {
            return arr.get(0).get(0);
        }

        if(i<0 ||j<0||j>=arr.get(i).size())
        {
            return Integer.MAX_VALUE-5000;
        }

        if(t[i][j]!=-1)
        {
            return t[i][j];
        }
        int l=arr.get(i).get(j)+solve(arr,i-1,j);
        int r=arr.get(i).get(j)+solve(arr,i-1,j-1);

        return t[i][j]= Math.min(l,r);
    }

    public int solve2(List<List<Integer>>arr)
    {
       int  dp[][] =new int [arr.size()][arr.get(arr.size()-1).size()];

       dp[0][0]=arr.get(0).get(0);

       for(int i=1;i<arr.size();i++)
       {
        for(int j=0;j<arr.get(i).size();j++)
        {
            int l=0;
            int r=0;

            if(j-1>=0)
            {
                r=arr.get(i).get(j)+dp[i-1][j-1];
            }
            else
            {
                r=Integer.MAX_VALUE;;
            }
            if(j>=arr.get(i-1).size())
            {
            l=Integer.MAX_VALUE;
            }
            else
            {
                l=arr.get(i).get(j)+dp[i-1][j];
            }

          dp[i][j]=Math.min(l,r);

        }
       }

       int min=Integer.MAX_VALUE;

       for(int j=0;j<dp[dp.length-1].length;j++)
       {
        min=Math.min(min,dp[dp.length-1][j]);
       }

       return min;
    }

    public int solve3(List<List<Integer>>arr,int i,int j)
    {
        if(i==arr.size()-1)
        {
           
            return arr.get(i).get(j);
        }
        if(t[i][j]!=-1)
        return t[i][j];

        int l=arr.get(i).get(j)+solve3(arr,i+1,j);
        int r=arr.get(i).get(j)+solve3(arr,i+1,j+1);

        return t[i][j]= Math.min(l,r);
    }

    public int solve4(List<List<Integer>>arr)
    {
          int  dp[][] =new int [arr.size()][arr.get(arr.size()-1).size()];

          for(int j=0;j<arr.get(arr.size()-1).size();j++)
          {
               dp[arr.size()-1][j]=arr.get(arr.size()-1).get(j);
          }

          for(int i=arr.size()-2;i>=0;i--)
          {
            for(int j=0;j<arr.get(i).size();j++)
            {
                int l=arr.get(i).get(j)+dp[i+1][j];
                int r=arr.get(i).get(j)+dp[i+1][j+1];

                 dp[i][j]=Math.min(l,r);
            }
          }

          return dp[0][0];
    }
}