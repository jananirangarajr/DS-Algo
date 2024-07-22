package leet.Neetcode.Graph;

public class MaxAreaOfIsland695 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
//        int[][] grid = {{1,1,0},{0,0,1},{1,1,1}};
        System.out.println(maxAreaOfIsland(grid));
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    maxCount = Math.max(maxCount,dfs(grid, i, j, 0));
                }
            }
        }
        return maxCount;
    }
    private static int dfs(int[][] grid, int row, int col, int count){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1)
            return count;
        count++;
        grid[row][col]=0;
        count = dfs(grid, row+1, col, count);
        count = dfs(grid, row-1, col, count);
        count = dfs(grid, row, col+1, count);
        count = dfs(grid, row, col-1, count);
        return count;
    }
}
