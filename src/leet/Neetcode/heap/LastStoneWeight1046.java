package leet.Neetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight1046 {
    public static void main(String[] args) {
        int[] stones = {1,3,4,7,4,2,8,5};
        System.out.println(lastStoneWeight(stones));
    }
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : stones) {
            queue.add(x);
        }
        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            if (x == y)
                continue;
            else {
                queue.add(x - y);
            }
        }
        return queue.size() >= 1 ? queue.poll() : 0;
    }
}
