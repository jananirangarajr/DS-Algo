package leet.Neetcode.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class IslandAndTreasureBFS {
    public static void main(String[] args) {
        int[][] grid = {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };
        islandsAndTreasure(grid);
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void islandsAndTreasure(int[][] grid) {

        //add the treasure to the queue then pop out one after another and mark it's neighbours distance as 1 and increment the distance as it goes on
        //this is like marking the all the neighbouring distance of treasure in parallel. and then the next neighbouring distance. BFS
        Queue<int[]> queue = (Queue<int[]>) new LinkedList<int[]>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int dist = 0;
        while(queue.size() > 0){
            int size = queue.size();
            for (int i = 0 ; i < size; i++){
                int[] treasureLoc = queue.remove();
                int row = treasureLoc[0];
                int col = treasureLoc[1];
                grid[row][col] = dist;
                //add neighbours to queue
                addRoom(grid, row+1, col, visited,queue);
                addRoom(grid, row-1, col ,visited, queue);
                addRoom(grid, row, col+1, visited, queue);
                addRoom(grid, row, col-1,visited, queue);
            }
            dist+=1;
        }
    }

    private static void addRoom(int[][] grid, int row, int col, boolean[][] visited, Queue<int[]> queue) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == -1)
            return;
        queue.add(new int[] {row, col});
        visited[row][col] = true;
    }
}
