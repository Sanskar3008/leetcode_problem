class Solution {
    public int minSteps(int n) {

        if(n<=1)
        return 0;

        int x =maxFac(n);

        if(x!=0)
        {
            return n/x+minSteps(x);
        }
        else
        {
            return n;
        }
        
    }

    int maxFac(int n)
    {
        for(int i=n-1; i>1;i--)
        {
            if(n%i==0)
            return i;
        }
        return 0;
    }
}