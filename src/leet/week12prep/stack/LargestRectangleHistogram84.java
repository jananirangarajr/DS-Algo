package leet.week12prep.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LargestRectangleHistogram84 {
    public static void main(String[] args) {
        int[] heights = new int[] {2,1,2};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 1)
            return heights[0];
        else {
            Deque<Integer> deque = new ArrayDeque<>();
            int area = 0;
            for (int x : heights) {
                if (!deque.isEmpty() && deque.getLast() > x){
                    while (!deque.isEmpty()) {
                        area = Math.max(area, deque.size()*deque.pollFirst());
                    }
                }
                deque.addLast(x);
            }
            if (!deque.isEmpty())
                area = Math.max(area, deque.size()*deque.pollFirst());
            return area;
        }
    }
}
