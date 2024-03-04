package algo.sorting;

import java.io.*;

public class MergeSort {
    public static void main(String[] args) throws IOException {

        int[] nums = new int[]{6,5,4,3,2,1};
        mergeSort(nums, 0, nums.length-1);
        for(int i : nums) {
            System.out.println(i);
        }
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left == right)
            return;
        else {
            int mid = (left+right)/2;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }

    private static void merge(int[] nums, int left, int mid,int right) {
        int[] copyArray = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= right) {
            if (j <= right && nums[i] >= nums[j]) {
                copyArray[k++] = nums[j++];
            }
            else if (i <= mid && nums[i] < nums[j]) {
                copyArray[k++] = nums[i++];
            }
        }
        //copy remaining elements
        while(i<= mid) {
            copyArray[k++] = nums[i++];
        }
        while(j <= right) {
            copyArray[k++] = nums[j++];
        }
        //update nums value
        for (i = left, k = 0; i <= right && k <=copyArray.length; i++,k++)
        {
            nums[i] = copyArray[k];
        }
    }
}
