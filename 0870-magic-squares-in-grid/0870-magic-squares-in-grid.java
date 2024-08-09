class Solution {
    public int findrowsum(int grid[][], int r, int c) {
        boolean visited[] = new boolean[10];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            int rowsum = 0;
            for (int j = 0; j < 3; j++) {
                int val = grid[r + i][c + j];
                if (val == 0 || val >= 10 || visited[val]) {
                    return -1;
                }
                visited[val] = true;
                rowsum += val;
            }
            if (i == 0) {
                sum = rowsum;
            } else {
                if (sum != rowsum) {
                    return -1;
                }
            }
        }
        return sum;
    }

    public int findcolsum(int grid[][], int r, int c) {
        int sum = 0;
        for (int j = 0; j < 3; j++) {
            int colsum = 0;
            for (int i = 0; i < 3; i++) {
                int val = grid[r + i][c + j];
                colsum += val;
            }
            if (j == 0) {
                sum = colsum;
            } else {
                if (sum != colsum) {
                    return -1;
                }
            }
        }
        return sum;
    }

    public int finddiagonalsum(int grid[][], int r, int c) {
        int sum1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2];
        int sum2 = grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c];
        if (sum1 == sum2) {
            return sum1;
        }
        return -1;
    }

    public boolean magicgrid(int grid[][], int r, int c) {
        int rowsum = findrowsum(grid, r, c);
        if (rowsum == -1)
            return false;
        int colsum = findcolsum(grid, r, c);
        if (colsum == -1)
            return false;
        int diagonalsum = finddiagonalsum(grid, r, c);
        if (diagonalsum == -1)
            return false;
        if (rowsum == colsum && rowsum == diagonalsum) {
            return true;
        }
        return false;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        if (row < 3 || col < 3) {
            count = 0;
        } else {
            for (int i = 0; i < row - 2; i++) {
                for (int j = 0; j < col - 2; j++) {
                    if (magicgrid(grid, i, j)) {
                        count++;
                    }
                }
            }

        }

        return count;
    }
}