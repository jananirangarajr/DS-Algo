package leet.week12prep.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        /*int rowLength = grid.length;
        int columnLength = grid[0].length;
        int count = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (grid[i][j] == '1'){
                    count +=1;
                    dfs(grid,i,j,rowLength,columnLength);
                }
            }
        }
        return count;*/
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int count = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                // if (grid[i][j] == '1'){
                //     count +=1;
                //     //dfs(grid,i,j,rowLength,columnLength);
                if (grid[i][j] == '1') {
                    count += 1;
                    grid[i][j] = '0';
                    Queue<Pair> q = new LinkedList();
                    q.add(new Pair(i,j));

                    while(!q.isEmpty()) {
                        Pair cur = q.remove();
                        int curi = cur.x;
                        int curj = cur.y;

                        //4 directions
                        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

                        for (int k = 0; k < directions.length; k++) {
                            int newi = curi + directions[k][0];
                            int newj = curj + directions[k][1];

                            if (newi >= 0 && newj >=0 && newi < rowLength && newj < columnLength && grid[newi][newj] == '1') {
                                grid[newi][newj] = '0';
                                q.add(new Pair(newi, newj));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j, int rowLength, int columnLength) {
        if (i < 0 || j < 0 || i >= rowLength || j >= columnLength || grid[i][j] != '1')
            return;
        grid[i][j] = 0;
        dfs(grid,i + 1,j,rowLength,columnLength);
        dfs(grid,i - 1,j,rowLength,columnLength);
        dfs(grid,i,j + 1,rowLength,columnLength);
        dfs(grid,i,j - 1,rowLength,columnLength);
    }
}
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}