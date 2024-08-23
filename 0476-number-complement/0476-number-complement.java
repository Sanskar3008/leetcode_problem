class Solution {
    public int findComplement(int num) {
        int ans=0;
        int i=0;
        if(num==0)
        return 1;
        while(num!=0)
        {
            int rem=num%2;
            if(1-rem==1)
            ans+=Math.pow(2,i);
            num=num/2;
            i++;
        }
        return ans;
    }
}