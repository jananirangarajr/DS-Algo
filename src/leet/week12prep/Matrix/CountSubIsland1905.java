package leet.week12prep.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class CountSubIsland1905 {
    public static void main(String[] args) {
        int[][] grid1 = {{1,0},{0,1}};
        int[][] grid2 = {{1,0},{1,1}};
//        System.out.println(countSubIslandsDFS(grid1, grid2));
        System.out.println(countSubIslands(grid1, grid2));
    }
    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;

        Queue q = new LinkedList();
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][] visited = new boolean[grid1.length][grid1[0].length];
        for (int i = 0; i < grid1.length; i++ ) {
            for (int j = 0; j < grid1[0].length; j++) {

                if (grid2[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        q.add(new Pair(i, j));
                        boolean flag = true;
                        while (!q.isEmpty()) {
                            Pair cur = (Pair) q.poll();

                            if (grid1[cur.x][cur.y] != 1)
                                flag = false;

                            for (int k = 0; k < directions.length; k++) {
                                int newi = cur.x + directions[k][0];
                                int newj = cur.y + directions[k][1];

                                if (newi >= 0 && newj >=0 && newi < grid2.length && newj < grid2[0].length && grid2[newi][newj] == 1 && !visited[newi][newj]){

                                    visited[newi][newj] = true;
                                    q.add(new Pair(newi,newj));
                                }
                            }
                        }
                        if (flag)
                            count++;
                    }
                }
            }

        return count;
    }

    public static int countSubIslandsDFS(int[][] grid1, int[][] grid2) {

        int count = 0;
        boolean[][] visited = new boolean[grid1.length][grid1[0].length];

        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {

                if (grid2[i][j] == 1 && !visited[i][j]) {
                    if(dfs(i,j,grid1,grid2,visited)) {
                        count++;
                    }
                }
            }
        }

        return count;

    }
    private static boolean dfs(int i, int j, int[][] grid1, int[][] grid2, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length || grid2[i][j] == 0 || visited[i][j])
            return true;

        boolean result = true;
        visited[i][j] = true;
        if (grid1[i][j] == 0)
            result = false;
        result = result & dfs(i-1,j,grid1,grid2,visited);
        result = result & dfs(i+1,j,grid1,grid2,visited);
        result = result & dfs(i,j-1,grid1,grid2,visited);
        result = result & dfs(i,j+1,grid1,grid2,visited);
        return result;

    }

}
