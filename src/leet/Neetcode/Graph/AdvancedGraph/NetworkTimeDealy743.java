package leet.Neetcode.Graph.AdvancedGraph;

import java.util.*;

public class NetworkTimeDealy743 {
    public static void main(String[] args) {
        int [][] times= new int[][] {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times,n,k));
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        //construct graph
        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++){
            graph.putIfAbsent(i, new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++){
            graph.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
        }

        //Dijikstra
        int cost = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((x,y) -> x[0]-y[0]);
        HashSet<Integer> visitSet = new HashSet<>();
        queue.add(new int[]{0,k});

        while(!queue.isEmpty() && visitSet.size() < n){
            int[] node = queue.poll();
            int curNode = node[1];
            int curCost = node[0];
            if (visitSet.contains(curNode)) {
                continue;
            }
            visitSet.add(curNode);
            cost = Math.max(cost,curCost);
            //bfs
            for (int[] neighbour : graph.get(node[1])){
                int nodeCost = neighbour[1];
                int nodeVal = neighbour[0];
                queue.add(new int[]{node[0]+nodeCost, nodeVal});
            }
        }
        if (visitSet.size() != n)
            return -1;
        return cost;
    }
}
