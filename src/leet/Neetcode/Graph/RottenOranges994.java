package leet.Neetcode.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges994 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting((grid)));
    }
    public static int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<int[]>();
        int fresh = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
//                    visited[i][j] = true;
                }
                if (grid[i][j] == 1)
                    fresh++;
            }
        }

        int minutes = 0;
        while(queue.size() > 0 && fresh > 0){
            int k = queue.size();
            for (int i = 0; i < k; i++){
                int[] rowCol = queue.remove();
                int row = rowCol[0];
                int col = rowCol[1];

                fresh = rottingNeighours(grid, row+1, col, queue,fresh);
                fresh = rottingNeighours(grid, row-1, col, queue,fresh);
                fresh = rottingNeighours(grid, row, col+1, queue,fresh);
                fresh = rottingNeighours(grid, row, col-1, queue,fresh);
            }
            minutes+=1;
        }
        return fresh == 0 ? minutes : -1;
    }

    private static int rottingNeighours(int[][] grid, int row, int col, Queue<int[]> queue, int fresh) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1){
            return fresh;
        }
        grid[row][col] = 2;
        queue.add(new int[] {row, col});
        return --fresh;
    }
}
