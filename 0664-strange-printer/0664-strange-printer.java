class Solution {
    public int solve(StringBuilder s, int l, int r, int dp[][]) {
        if (l == r) return 1;
        if (l > r) return 0;
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        int i = l+1;
        while (i <= r) {
            if (s.charAt(i) == s.charAt(l)) {
                i++;
            } else {
                break;
            }
        }
        if (i > r) return 1;
        int ans1 = 1 + solve(s, i, r, dp);
        int res = Integer.MAX_VALUE;
        for (int j = i; j <= r; j++) {
            if (s.charAt(j) == s.charAt(l)) {
                int ans2 = solve(s, i, j-1, dp) + solve(s, j, r,dp);
                res = Math.min(res, ans2);
            }
        }

        return dp[l][r] = Math.min(res, ans1);
    }
    public int strangePrinter(String s) {
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(new StringBuilder(s), 0, n-1, dp);
    }
}