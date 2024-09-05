class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        // n => missing values
        int givenValues = 0;
        for(int i : rolls) {
            givenValues += i;
        }

        int missingValues = (mean * (rolls.length + n)) - givenValues;

        if(missingValues < n || missingValues > 6*n)
            return new int[0];
        
        int num = missingValues / n;

        int[] ans = new int[n];

        for(int i=0; i<n; i++) {
            ans[i] = num;
        }

        missingValues %= n;

        int i=0;
        while(missingValues > 0 && i < n) {
            if(ans[i] + missingValues <= 6) {
                ans[i] += missingValues;
                missingValues = 0;
                i++;
            }
            else {
                int temp = 6 - ans[i];
                ans[i] = 6;
                missingValues -= temp;
            }
            i++;
        }

        return ans;
    }
}