class Solution {
    private static final int HASH_MULTIPLIER = 60001;

    private int hash(int x, int y) {
        return x + HASH_MULTIPLIER * y;
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> obsSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obsSet.add(hash(obstacle[0], obstacle[1]));
        }

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[] origin = { 0, 0 };
        int currDir = 0;
        int maxDest = 0;
        for (int com : commands) {
            if (com == -1) {
                currDir = (currDir + 1) % 4;
                continue;
            }
            if (com == -2) {
                currDir = (currDir + 3) % 4;
                continue;
            }
            int dir[] = directions[currDir];
            for (int step = 0; step < com; step++) {
                int x = origin[0] + dir[0];
                int y = origin[1] + dir[1];
                if (obsSet.contains(hash(x, y))) {
                    break;
                }
                origin[0] = x;
                origin[1] = y;
            }
            maxDest = Math.max(maxDest, (origin[0] * origin[0]) + (origin[1] * origin[1]));
        }

        return maxDest;
    }
}