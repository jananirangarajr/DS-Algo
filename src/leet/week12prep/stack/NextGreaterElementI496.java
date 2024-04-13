package leet.week12prep.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI496 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        int[] result = nextGreaterElement(nums1,nums2);

        Arrays.stream(result).forEach(System.out::println);
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> result = new HashMap<>();
        int n = nums2.length;
        for (int i = 0; i < n; i++) {
            while(!stack.empty() && nums2[stack.peek()] < nums2[i]){
                result.put(nums2[stack.peek()],nums2[i]);
                stack.pop();
            }
            stack.push(i);
        }
        int[] greaterElement = new int[nums1.length];
        for (int i = 0; i < nums1.length;i++){
            greaterElement[i] = result.getOrDefault(nums1[i],-1);
        }
        return greaterElement;
    }
}
