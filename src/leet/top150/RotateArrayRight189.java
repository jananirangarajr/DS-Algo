package leet.top150;

public class RotateArrayRight189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        rotate(nums,5);
        for (int n : nums)
            System.out.println(n);
    }

    private static void rotate(int[] nums, int k) {
        //swaps the k elements with the last k elements
        /*if (k ==0 || k == nums.length)
            return;
        if ( k > nums.length)
            k -= nums.length;
        int n = nums.length;
        int parts = nums.length/k;
        for (int i = 1; i <= parts; i++) {
            int l = n-k;
            for (int j = (i*k)-k; j < i*k; j++) {
                swap(j,l,nums);
                l++;
            }
        }*/
        //didn't work for the 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27 & k =38
        // expected output : 17,18,19,20,21,22,23,24,25,26,27,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16
        //output generated : 17,18,19,20,21,22,23,24,25,26,27,1,2,3,4,5,6,7,8,9,10,11,13,14,15,16,12

        if (nums.length == k || k == 0)
            return;
        if (k > nums.length)
            k -= nums.length;
        rotate(nums, k, 0, nums.length-k-1);
        rotate(nums,k, nums.length-k,nums.length-1);
        rotate(nums,k,0, nums.length-1);

    }

    private static void rotate(int[] nums, int k, int left, int right) {
        while(right > left) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    private static void swap(int j, int i, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
