package leet.week12prep.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,1,2,0,5};
        int k = 3;
        int[] result = maxSlidingWindow(nums,k);
        for (int x: result)
            System.out.print(x+" ");
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int start = 0, end = 0, max = nums[0], maxIndex=0;
        int len = nums.length;
        int[] result = new int[len-(k-1)];

        /* for (;end < k; end++ ) {
           if (max <= nums[end]){
                max = nums[end];
                maxIndex = end;
            }
        }
        if (end == len) {
            result[start] = max;
            return result;
        }
        while(end < len) {
            System.out.println(max+" "+maxIndex+" "+start+" "+end);
            result[start] = max;
            start++;
            if (maxIndex < start) {
                //iterate throught the values from start+1 to end and find max
                max = Integer.MIN_VALUE;
                for (int i = start; i <= end; i++){
                    if (max <= nums[i]){
                        max = nums[i];
                        maxIndex = i;
                    }
                }
            }
            if (max <= nums[end]){
                max = nums[end];
                maxIndex = end;
            }

            end++;
        }
        result[start] = max;
        //not time efficient in large no of testcases
        */

            //alternative approach with deque, insert the index value when the previous value is large else deque it. Add it to result array
            Deque deque = new ArrayDeque();
            for (; end < len; end++) {
                //deque if the start pointer is moved
                while (!deque.isEmpty() && (int) deque.peek() < end - k + 1)
                    deque.poll();

                // add elements only when the previous value is less, else remove it
                while (!deque.isEmpty() && nums[(int) deque.peekLast()] < nums[end])
                    deque.pollLast();

                deque.offer(end);

                if (end >= k-1)
                    result[start++] = nums[(int) deque.peek()];
            }
            return result;
        }
}
