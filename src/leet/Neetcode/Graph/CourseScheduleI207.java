package leet.Neetcode.Graph;

import java.util.*;

public class CourseScheduleI207 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{1,3}};
        System.out.println(canFinish(numCourses,prerequisites));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visitSet = new HashSet<>();

        for (int i = 0; i < prerequisites.length; i++){
            map.putIfAbsent(prerequisites[i][0],new ArrayList<Integer>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        //to add the edge nodes
        for (int i = 0; i < numCourses; i++){
            map.putIfAbsent(i,new ArrayList<Integer>());
        }

        for (int i = 0 ; i < numCourses; i++){
            if(!dfs(map,visitSet,i))
                return false;
        }
        return true;
    }

    private static boolean dfs(HashMap<Integer, List<Integer>> map, Set<Integer> visitSet, int index){
        if(visitSet.contains(index))
            return false;
        if (map.get(index) == null)
            return true;
        visitSet.add(index);
        for (int i : map.get(index)){
            if(!dfs(map,visitSet,i))
                return false;
        }
        visitSet.remove(index);
        map.put(index, new ArrayList<>());
        return true;
    }

}
