package leet.Neetcode.Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class NumberofIslandBFS200 {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0'},{'0','1','0'},{'0','0','0'}};
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int count = 0;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++){
                if (grid[i][j] == '1'){
                    count+= 1;
                    grid[i][j] = '0';
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i,j});

                    while(q != null){
                        int[] rowCol = q.remove();

                        //check 4 directions and add it to the queue to process 1 set
                        int[][] directons = {{1,0},{-1,0},{0,1},{0,-1}};
                        for (int k = 0; k < 4; k++){
                            int[] newPair= directons[k];
                            int row = newPair[0]+rowCol[0];
                            int col = newPair[1]+rowCol[1];
                            if (row > 0 && col > 0 && row < rowLength && col < colLength && grid[row][col] == '1'){
                                grid[row][col] = '0';
                                q.add(new int[]{row,col});
                            }
                        }
                    }


                }
            }
        }
        return count;
    }
}
