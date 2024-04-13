package leet.week12prep.Graph;

import java.util.*;

public class CourseSchedule207 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(canFinish(numCourses,prerequisites));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        //construct adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            graph.putIfAbsent(i,new ArrayList<>()); // to add disconnected graph
            graph.putIfAbsent(prerequisites[i][0],new ArrayList<>());
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Set<Integer> cycle = new TreeSet<>();
        boolean[] visited = new boolean[numCourses];

        for (Map.Entry<Integer,List<Integer>> node : graph.entrySet()) {
            boolean result = dfs(cycle,visited,node.getKey(), graph);
            if (!result)
                return result;
        }
        return true;
    }

    private static boolean dfs(Set<Integer> cycle, boolean[] visited, Integer node, Map<Integer, List<Integer>> graph) {
        if (graph.get(node).isEmpty())
            return true;
        if (cycle.contains(node) || visited[node])
            return false;
        cycle.add(node);
        visited[node] = true;
        for (int neighbour : graph.get(node)){
            if (!visited[neighbour]){
                boolean result = dfs(cycle,visited,neighbour,graph);
                if (!result)
                    return result;
            }
        }
        graph.get(node).clear();
        return true;

    }
}
