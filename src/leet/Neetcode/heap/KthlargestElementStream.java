package leet.Neetcode.heap;


import java.util.PriorityQueue;

public class KthlargestElementStream {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] {7,4,3,6,8,3});
        System.out.println(kthLargest.add(15));
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(10));
    }

    static class KthLargest {
        PriorityQueue<Integer> priorityQueue;
        int K;
        KthLargest(int k, int[] nums) {
            priorityQueue = new PriorityQueue<>();
            this.K = k;
            for (int x : nums)
                add(x);
        }
        int add(int val) {
            priorityQueue.add(val);
            while(priorityQueue.size() > K){
                priorityQueue.remove();
            }
            return priorityQueue.peek();
        }
    }
}
