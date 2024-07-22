package leet.Neetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ValidTree {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println(validTree(n,edges));
    }
    public static boolean validTree(int n, int[][] edges) {

        if (edges.length == n)
            return false;

        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        boolean[] visit = new boolean[n];

        for (int i = 0; i < edges.length; i++){
            graph.putIfAbsent(edges[i][0],new ArrayList<>());
            graph.putIfAbsent(edges[i][1],new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        dfs(graph,visit,0);

        for (int i = 0; i < n; i++){
            if (!visit[i])
                return false;
        }
        return true;
    }
    private static void dfs( HashMap<Integer, List<Integer>> graph, boolean[] visit, int index){
        if (visit[index])
            return;
        visit[index] = true;
        for (int node : graph.get(index)){
            dfs(graph,visit,node);
        }
        return;
    }
}
