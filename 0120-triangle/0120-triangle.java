class Solution {
    int t[][]=new int [201][201];
    public int minimumTotal(List<List<Integer>> triangle) {

        for(int i=0;i<t.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<triangle.get(triangle.size()-1).size();i++)
        {
        min=Math.min(min,solve(triangle,triangle.size()-1,i));
        }
        return min;
        
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
}