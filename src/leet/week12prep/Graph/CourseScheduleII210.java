package leet.week12prep.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII210 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[] result = findOrder(numCourses,prerequisites);
        for (int i : result)
            System.out.println(i);
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        //graph, adjacency list, do dfs
        //initialize visited, add it to the result array
        // return new int[numCourses];
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            graph.putIfAbsent(i,new ArrayList<>());
            graph.putIfAbsent(prerequisites[i][0],new ArrayList<>());
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            // graph.put(prerequisites[i][1],);
        }

        for (Map.Entry<Integer, List<Integer>> entry: graph.entrySet()) {
            int key = entry.getKey();
            List<Integer> neighbours = entry.getValue();
            if (!visited[key]){
                visited[key] = true;
                result.add(key);
                for (int i = 0; i < neighbours.size(); i++){
                    dfs(graph, neighbours.get(i), visited, result);
                }
            }
        }
        int arr[] = new int[result.size()];
        for (int i = 0; i < result.size();i++)
            arr[i]= result.get(i);
        return arr;
    }
    private static void dfs(Map<Integer,List<Integer>> graph, int node, boolean[] visited, List<Integer> result){
        if (!graph.containsKey(node)) {
            visited[node] = true;
            result.add(node);
        }
        if (visited[node])
            return;
        visited[node] = true;
        result.add(node);
        for (int key : graph.get(node)) {
            dfs(graph,key,visited,result);
        }
        return;
    }
}
