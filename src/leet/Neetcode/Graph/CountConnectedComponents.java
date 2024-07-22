package leet.Neetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountConnectedComponents {
    public static void main(String[] args) {
        int n = 12;
        int[][] edges = {{0,1},{1,2},{2,3},{3,0},{4,5},{6,7},{7,4},{8,9},{10,11}};
        System.out.println(countComponents(n,edges));
    }
    public static int countComponents(int n, int[][] edges) {

        if(n == 1 || edges.length == 0)
            return n;
        if (edges.length == n)
            return 1;
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        boolean[] visit = new boolean[n];

        //construct graph
        for (int i = 0; i < edges.length; i++){
            graph.putIfAbsent(edges[i][0],new ArrayList<>());
            graph.putIfAbsent(edges[i][1],new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        //adding leaf nodes
        for (int i = 0; i < n; i++){
            graph.putIfAbsent(i,new ArrayList<>());
        }
        int count = 0;
        for (int i = 0 ; i < n; i++){
            if(!visit[i]){
                count += 1;
                dfs(graph,visit,i);
            }
        }
        return count;
    }
    private static void dfs(HashMap<Integer, List<Integer>> graph, boolean[] visit, int node){
        if (visit[node])
            return;
        visit[node] = true;
        for (int i : graph.get(node))
            dfs(graph, visit, i);
    }
}
