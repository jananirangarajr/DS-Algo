package leet.Neetcode.Graph.AdvancedGraph;

import java.util.*;

public class MinCostToConnectAllPoints1584 {
    public static void main(String[] args) {
        int[][] points = {{0,0}};
        System.out.println(minCostConnectPoints(points));
    }
    public static int minCostConnectPoints(int[][] points) {
        //minimum spanning tree

        //construct weighted graph
        HashMap<Integer,List<int[]>> graph = new HashMap<Integer, List<int[]>>();
        for (int i = 0; i < points.length-1; i++){
           for (int j = i+1; j < points.length;j++){
               graph.putIfAbsent(i,new ArrayList<int[]>());
               graph.putIfAbsent(j,new ArrayList<>());
               int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
               graph.get(i).add(new int[] {dist,j});
               graph.get(j).add(new int[] {dist,i});
           }
        }
        //prims - BFS
        int cost= 0;
        HashSet<Integer> visitSet = new HashSet<>();
        PriorityQueue<int[]>  queue = new PriorityQueue<int[]>((x,y) -> x[0]-y[0]);
        queue.add(new int[]{0,0});

        while(!queue.isEmpty() && visitSet.size() < points.length && graph.size() > 0){
            int[] point = queue.poll();
            int node = point[1];
            if (visitSet.contains(node))
                continue;
            visitSet.add(node);
            int dist = point[0];
            cost+=dist;

            for (int[] neighbours : graph.get(node)){
                queue.add(neighbours);
            }
        }
        return cost;

    }
}
