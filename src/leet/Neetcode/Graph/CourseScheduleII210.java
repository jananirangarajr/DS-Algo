package leet.Neetcode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
        for (int i = 0; i < numCourses; i++){
            if (!completedCourses[i]){
                dfs(map,completedCourses,result,i);
            }
        }
        int[] r = result.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(result);
        return r;
    }

    private static void dfs(HashMap<Integer, List<Integer>> map, boolean[] visited, List<Integer> result, int index){
        if (visited[index])
            return;
        if(!map.containsKey(index)){
            result.add(index);
            visited[index] = true;
            return;
        }
        for(int i : map.get(index)){
            dfs(map,visited,result,i);
        }
        visited[index] = true;
        result.add(index);
    }
}
