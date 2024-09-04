class Solution {
    public int returnSum(int digit) {
        int temp = digit, sum = 0;
        while (temp > 0) {
            sum = sum + (temp % 10);
            temp = temp / 10;
        }
        return sum;
    }

    public int getLucky(String s, int k) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum + returnSum(s.charAt(i) - 97 + 1);
        }
        if (k == 1) {
            return sum;
        }
        k--;
        int temp = sum, secSum = 0;
        while (k > 0) {
            secSum = 0;
            secSum = returnSum(temp);
            temp = secSum;
            k--;
        }
        return secSum;
    }
}