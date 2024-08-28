class Solution {
    class Dir{
        int xDelta;
        int yDelta;
        Dir(int xDelta1, int yDelta1){
            xDelta = xDelta1;
            yDelta = yDelta1;
        }
    }
    class Pos{
        int x;
        int y;
        Pos(int x1, int y1){
            x = x1;
            y = y1;
        }
    }
    void populateDirections(){
        dirs.add(new Dir(0,1));
        dirs.add(new Dir(0,-1));
        dirs.add(new Dir(1,0));
        dirs.add(new Dir(-1,0));
    }
    Pos getPos(Pos pos, Dir dir) throws Exception{
        int newX = pos.x + dir.xDelta, newY = pos.y + dir.yDelta;
        // check bounds
        if(newX >= 0 && newX < m && newY >= 0 && newY < n){
            return new Pos(newX, newY);    
        }
        throw new Exception("Out of bounds " + newX + " " + newY);
    }
    List<Dir> dirs = new ArrayList<>();
    int subIslands = 0, m, n;
    boolean[][] vis;
    int[][] g1, g2;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        populateDirections();
        m = grid1.length;
        n = grid1[0].length;
        g1 = grid1;
        g2 = grid2;
        vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j] && (g2[i][j] == 1)){
                    boolean isSubIsland = dfs(new Pos(i, j));
                    if(isSubIsland) subIslands++;
                }
            }
        }
        return subIslands;
    }
    boolean dfs(Pos pos){
        int i = pos.x, j = pos.y;
        if(vis[i][j] || (g2[i][j] == 0)) return true;
        vis[i][j] = true;
        boolean isSubIsland = (g1[i][j] == 1);
        for(Dir d : dirs){
            try{
                Pos newPos = getPos(pos, d);
                isSubIsland = dfs(newPos) && isSubIsland;
            }catch(Exception e){
                // out of bounds
            }
        }
        return isSubIsland;
    }
}