package leet.Neetcode.Graph;

import java.util.*;

public class CourseScheduleII210 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[] r = findOrder(numCourses,prerequisites);
        System.out.println(Arrays.asList(r));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        boolean[] completedCourses = new boolean[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++){
            map.putIfAbsent(prerequisites[i][0],new ArrayList<Integer>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> cycle = new HashSet<>();
        for (int i = 0; i < numCourses; i++){
            if (!dfs(map,completedCourses,result,i,cycle))
                return new int[0];
        }
        int[] r = result.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(result);
        return r;
    }

    private static boolean dfs(HashMap<Integer, List<Integer>> map, boolean[] visited, List<Integer> result, int index, HashSet<Integer> cycle){
        if (cycle.contains(index))
            return false;
        if (visited[index])
            return true;
        if(!map.containsKey(index)){
            result.add(index);
            visited[index] = true;
            return true;
        }
        cycle.add(index);
        for(int i : map.get(index)){
            if(!dfs(map,visited,result,i,cycle))
                return false;
        }
        cycle.remove(index);
        visited[index] = true;
        result.add(index);
        return true;
    }
}
