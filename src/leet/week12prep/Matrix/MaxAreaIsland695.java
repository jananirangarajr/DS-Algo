package leet.week12prep.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaIsland695 {
    public static void main(String[] args) {
        int[][] grid = {
//                {0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},
//                {0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}
                {1,1,0},{1,0,0}
        };
        System.out.println(maxAreaOfIslandDFS(grid));
    }

    public static int maxAreaOfIslandDFS(int[][] grid) {
        int rowlength = grid.length;
        int colLength = grid[0].length;
        int max = 0;
        for (int i = 0; i < rowlength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 1) {
                    int count = maxAreaOfIsland(grid, rowlength, colLength, i, j, 0);
                    max = Math.max(count,max);
                }
            }
        }
        return max;

    }

    private static int maxAreaOfIsland(int[][] grid, int rowlength, int colLength, int i, int j, int count) {
        if (i < 0 || j < 0 || i >= rowlength || j >= colLength || grid[i][j] != 1)
            return 0;
        else {
            grid[i][j] = 0;
           return 1+ maxAreaOfIsland(grid, rowlength, colLength, i-1, j, count) + maxAreaOfIsland(grid, rowlength, colLength, i+1, j, count)
            + maxAreaOfIsland(grid, rowlength, colLength, i, j-1, count) + maxAreaOfIsland(grid, rowlength, colLength, i, j+1, count);
        }
    }

    public static int maxAreaOfIsland(int[][] grid) {

        int max= 0;
        int rowlength = grid.length;
        int collength = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int i = 0; i < rowlength; i++){
            for (int j = 0; j < collength; j++) {
                int count = 0;
                if (grid[i][j] == 1) {
                    count++;
                    queue.add(new Pair(i,j));
                    grid[i][j] = 0;

                    while (!queue.isEmpty()) {
                        Pair cur = queue.remove();

                        for (int k = 0; k < directions.length; k++) {
                            int newi = cur.x + directions[k][0];
                            int newj = cur.y + directions[k][1];

                            if (newi >= 0 && newi < rowlength && newj >= 0 && newj <= collength && grid[newi][newj] == 1){
                                count++;
                                grid[newi][newj] = 0;
                                queue.add(new Pair(newi, newj));
                            }
                        }

                    }
                    max = Math.max(count, max);
                }
            }
        }
        return max;

    }
}
