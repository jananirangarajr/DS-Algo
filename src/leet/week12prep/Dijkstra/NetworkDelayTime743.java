package leet.week12prep.Dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime743 {
    public static void main(String[] args) {
        int k = 2;
        int n = 4;
        int[][] times = {
                {2,1,1}, {2,3,1}, {3,4,1}
        };
        System.out.println(networkDelayTime(times,n,k));
    }
    public static int networkDelayTime(int[][] times, int n, int k) {

        //construct graph
        Map<Integer, Map<Integer,Integer>> graph = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            graph.putIfAbsent(times[i][0],new HashMap<>());
            graph.get(times[i][0]).put(times[i][1],times[i][2]);
        }

        //bfs with priority Queue

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        int t = 0;
        boolean[] visited = new boolean[n];
        queue.add(new int[]{0, k});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int distance = cur[0];
            int node = cur[1];
            if (visited[node]) continue;
            visited[node] = true;
            t = Math.max(t,distance);
            if (graph.containsKey(node)) {
                for (int next: graph.keySet()) {
                    queue.add(new int[]{distance+graph.get(node).get(next),next});
                }
            }

        }

        return t;

    }
}
