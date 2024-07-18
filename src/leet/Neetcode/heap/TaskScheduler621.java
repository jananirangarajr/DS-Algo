package leet.Neetcode.heap;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler621 {
    public static void main(String[] args) {
        char[] tasks = {'a','b','a','a','b','b'};
        int n = 2;
        System.out.println(leastInterval(tasks,n));
    }
    public static int leastInterval(char[] tasks, int n) {
//         count the frequency and add it to the heap - max heap
//         reduce the frequency and add it to the queue with new time interval
//         add the frequency back to the heap if time interval matches
//        do it until all task gets completed

        //count frequency
        HashMap<Character,Integer> map = new HashMap<>();
        for (char x : tasks){
            map.putIfAbsent(x,0);
            map.put(x, map.get(x)+1);
        }

        //construct max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x, y) -> y - x);
        for (Map.Entry<Character, Integer> e : map.entrySet()){
            pq.add(e.getValue());
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int time = 0;

        while(!pq.isEmpty() || !queue.isEmpty()) {
           if (!pq.isEmpty()){
               int freq =  pq.remove();
               freq--;
               if (freq != 0)
                queue.add(new int[]{freq,time+n});
           }
           if(!queue.isEmpty() && queue.peekFirst()[1] == time)
           {
               pq.add(queue.remove()[0]);
           }
           time++;
        }
        return time;

    }
}
