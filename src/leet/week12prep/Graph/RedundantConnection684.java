package leet.week12prep.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedundantConnection684 {
    public static void main(String[] args) {
        int[][] edges = {
                {1,2},{1,3},{2,3}
        };
        int[] result = findRedundantConnection(edges);
        System.out.println(result[0]+" "+result[1]);
    }
    public static int[] findRedundantConnection(int[][] edges) {
        //form graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0],new ArrayList<>());
            graph.putIfAbsent(edges[i][1],new ArrayList<>());

            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

//        dfs(edges[])
        return null;
    }
}
