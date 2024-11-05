class Solution {
    public int kthGrammar(int n, int k) {
        int ans=find(n,k);

    return ans;    
    }
  public int find(int n,int k)
 {
    if(n==1 &&k==1)
    {
        return 0;
    }

   int size=(int)Math.pow(2,n-1);
    if(k<=(size/2))
    {
        return find(n-1,k);
    }
    
    
        return 1-find(n-1,k-(size/2));
    
  }

}