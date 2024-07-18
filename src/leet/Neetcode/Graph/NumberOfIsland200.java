package leet.Neetcode.Graph;

public class NumberOfIsland200 {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0'},{'0','1','0'},{'0','0','0'}};
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1')
                    if(dfs(grid, i, j))
                        count++;
            }
        }
        return count;
    }
    private static boolean dfs(char[][] grid,int row, int col){
        if(row < 0 || row >= grid.length || col <0 || col >= grid[0].length || grid[row][col] == '/')
            return false;
        if(grid[row][col] == '0')
            return true;
        grid[row][col] = '/';
        boolean down = dfs(grid, row +1, col);
        boolean up = dfs(grid, row -1, col);
        boolean right =  dfs(grid, row, col+1);
        boolean left = dfs(grid, row, col-1);
        return right || left || up || down;
    }
}
