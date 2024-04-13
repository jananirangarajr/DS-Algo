package leet.week12prep.Matrix;

public class IslandPerimeter463 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,},{1,1}
        };

    }
    public int islandPerimeter(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 1) {
                    //check four directions
                    if (i -1 >=0 && grid[i-1][j] != 1)
                        perimeter += 1;
                    if (i+1 < rowLength && grid[i+1][j] != 1)
                        perimeter += 1;
                    if (j-1 >= 0 && grid[i][j-1] != 1)
                        perimeter += 1;
                    if (j+1 < colLength && grid[i][j+1] != 1)
                        perimeter += 1;
                }
            }
        }
        return perimeter;

    }
}
