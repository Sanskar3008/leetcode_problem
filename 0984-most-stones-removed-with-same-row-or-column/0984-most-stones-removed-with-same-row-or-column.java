import java.util.HashSet;

class Solution {
    public int removeStones(int[][] stones) {
        HashSet<Integer> visited = new HashSet<>();
        int numcomponentcount = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!visited.contains(i)) {
                dfs(stones, i, visited);
                numcomponentcount++;
            }
        }
        return stones.length - numcomponentcount;
    }

    private void dfs(int[][] stones, int index, HashSet<Integer> visited) {
        visited.add(index);
        for (int i = 0; i < stones.length; i++) {
            if (!visited.contains(i) &&
                (stones[i][0] == stones[index][0] || stones[i][1] == stones[index][1])) {
                dfs(stones, i, visited);
            }
        }
    }
}