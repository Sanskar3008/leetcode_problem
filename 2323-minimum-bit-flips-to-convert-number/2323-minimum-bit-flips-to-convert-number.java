class Solution {
    public int minBitFlips(int start, int goal) {
        int exor=start^goal,c=0;
        while(exor>0){
            exor=exor&(exor-1);
            c++;
        }return c;
    }
}