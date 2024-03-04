package algo.sorting;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
//        int[] nums = new int[] {1,2};
        int[] nums = new int[] {5,6,4,3,2,1,4};
        quickSort(nums,0,nums.length-1);
        for (int n : nums) {
            System.out.println(n);
        }
    }
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        else {
            int i = left;
            int j = right;
            int pivot = right;
            right = right-1;
            while(left < right) {
                if (nums[left] <= nums[pivot]) left++;
                else if (nums[right] >= nums[pivot]) right--;
                else {
                   int temp = nums[left];
                   nums[left] = nums[right];
                   nums[right] = temp;
                }
            }
            if (right >= left && nums[left]> nums[pivot]) {
                int temp = nums[left];
                nums[left] = nums[pivot];
                nums[pivot] = temp;
            }
            quickSort(nums,i,right);
            quickSort(nums,left+1,j);
        }
    }
}
