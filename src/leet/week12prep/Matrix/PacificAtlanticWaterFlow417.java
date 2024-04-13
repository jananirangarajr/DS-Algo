package leet.week12prep.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow417 {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));
    }
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {

        //find the regions that reach pacific from top row and left column[do Dfs]
        // find the regions that reach atlantic from bottom row and right column[do DFS]
        // find the common regions and return

        int rowLength = heights.length;
        int colLength = heights[0].length;

//        List<int[]> pacific = new ArrayList<>();
//        List<int[]> atlantic = new ArrayList<>();

        boolean[][] pacific = new boolean[rowLength][colLength];
        boolean[][] atlantic = new boolean[rowLength][colLength];

        for (int i = 0; i < colLength; i++) {
            dfs(0,i,heights,heights[0][i],pacific); //top
            dfs(rowLength-1,i,heights,heights[rowLength-1][i],atlantic); //bottom
        }

        for (int i = 0; i < rowLength; i++) {
            dfs(i,0,heights,heights[i][0],pacific);//left
            dfs(colLength-1,i,heights,heights[i][colLength-1],atlantic);//right
        }

        List<List<Integer>> result = new ArrayList<>();
        //find common in list
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i,j));
            }
        }


        return result;

    }

    private static void dfs(int r, int c, int[][] heights, int prevHeight, boolean[][] visit) {
        if (r < 0 || c < 0 || r == heights.length || c == heights[0].length || heights[r][c] < prevHeight|| visit[r][c])
            return;
        visit[r][c] = true;
        dfs(r-1,c,heights,heights[r][c],visit);
        dfs(r+1,c,heights,heights[r][c],visit);
        dfs(r,c - 1,heights,heights[r][c],visit);
        dfs(r,c + 1,heights,heights[r][c],visit);
    }
}
