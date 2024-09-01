class Solution {
    public int[][] construct2DArray(int[] arr, int m, int n) {
        if (arr.length != m * n) return new int[][]{};
        int[][] nums = new int[m][n];
        int x = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = arr[x++];
            }
        }
        return nums;
    }
}