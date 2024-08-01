package leet.Neetcode.Graph.AdvancedGraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SwimRisingWater778 {

    public static void main(String[] args) {
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
//        int[][] grid = {{10,12,4,6},{9,11,3,5},{1,7,13,8},{2,0,15,14}};
        System.out.println(swimInWater(grid));
    }
    public static int swimInWater(int[][] grid) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((x,y)->x[0]-y[0]);
        queue.add(new int[]{grid[0][0],0,0});
        int size = grid.length;
        boolean[][] visitSet = new boolean[size][size];

        int[][] directions =  {{0,-1},{-1,0},{1,0},{0,1}};
        while (!queue.isEmpty() && (queue.peek()[1] != size-1 || queue.peek()[2] != size-1)){
            int[] node = queue.poll();
            visitSet[node[1]][node[2]] = true;
            //do bfs
            for(int i = 0; i < 4; i++){
                int newRow = node[1]+directions[i][0];
                int newCol = node[2]+directions[i][1];
                if( newRow >=0 && newCol >= 0 && newRow < size && newCol < size && !visitSet[newRow][newCol]){
                    int pathMax = Math.max(grid[newRow][newCol],node[0]);
                    queue.add(new int[]{pathMax,newRow,newCol});
                }
            }
            if (!queue.isEmpty()) {
                int[] minPath = queue.poll();
                queue.add(minPath);
            }
        }
        return queue.peek()[0];
    }
}
