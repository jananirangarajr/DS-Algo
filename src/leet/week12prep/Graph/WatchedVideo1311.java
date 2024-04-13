package leet.week12prep.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class WatchedVideo1311 {
    public static void main(String[] args) {
        String[][] videoArray = {{"A","B"},{"C"},{"B","C"},{"D"}};
        List<List<String>> watchedVideos = Arrays.stream(videoArray).map(Arrays::asList).collect(Collectors.toList()); //map applies function to the stream elements
        int[][] friends = {{1,2},{0,3},{0,3},{1,2}};
        List<String> result = watchedVideosByFriends(watchedVideos,friends, 0, 1);
        System.out.println(result);

    }
    public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        //form graph
        //find level friends
        // count/track the videos they watched.
        //return sorted list(priority Queue)

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < friends.length; i++){
            for (int j = 0; j < friends[i].length; j++) {
                graph.putIfAbsent(i, new ArrayList<>());
                graph.putIfAbsent(friends[i][j],new ArrayList<>());
                graph.get(i).add(friends[i][j]);
               // graph.get(friends[i][j]).add(i);
            }
        }
//        for (Map.Entry<Integer,List<Integer>> entry : graph.entrySet()) {
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }
        Map<String, Integer> resultMap = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[friends.length];

        q.add(new int[]{id,0});
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int curLevel = node[1];
            visited[node[0]] = true;
            for (int friend : graph.get(node[0])) {
                if (!visited[friend]) {
                    q.add(new int[]{friend, curLevel+1});
                    if (curLevel+1 == level){
                        for (String video : watchedVideos.get(friend)) {
                            if (resultMap.containsKey(video))
                                resultMap.put(video,resultMap.get(video)+1);
                            else
                                resultMap.put(video,1);
                        }
                    }
                }
            }
        }

        List<String> keys = new ArrayList<>( resultMap.keySet());
        keys.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int f1 = resultMap.get(o1);
                int f2 = resultMap.get(o2);
                if (f1 == f2) return o1.compareTo(o2);
                return f1-f2;
            }
        });
        return keys;
    }


}
