package leet.top150;

public class MergeSortedArray {

    //https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        int n = 3;
        int m = 3;

        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};

        int k = m+n-1;
//        if (n == 0)
//            return;
//        else{
//
//            m = m-1;
//            n -=1;
//
//            while(m >= 0 &&  n >= 0) {
//                if (nums1[m] > nums2[n]) {
//                    System.out.println(k);
//                    nums1[k--] = nums1[m--];
//                }
//                else {
//                    nums1[k--] = nums2[n--];
//                }
//            }
//
//        }
//        if (n >= 0) {
//            while(k >=0){
//                nums1[k--] = nums2[n--];
//            }
//        }
        //Optimal solution
        while(n >= 0) {
            if (m >= 0 && nums1[m] > nums2[n])
                nums1[k--] = nums1[m--];
            else
                nums1[k--] = nums2[n--];
        }

        for (int num: nums1)
            System.out.print(" "+num);
    }
}
/**
 * Missed Test Cases
 * nums1 = [2,0] m =1 nums2 = [1] n =1
 * nums1 = [0,0,0,0,0] m = 0 nums2 =[1,2,3,4,5] n = 5
 */