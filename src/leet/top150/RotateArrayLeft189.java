package leet.top150;

public class RotateArrayLeft189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums,3);
        for (int n : nums)
            System.out.println(n);

    }
    public static void rotate(int[] nums, int k) {
        int parts = nums.length/k;
        for (int i = 1 ; i <= parts; i++) {
            for (int j = (i*k) - k; j < i*k; j++){
                if (j+k >=nums.length)
                    swap(j,nums.length-1,nums);
                else
                    swap(j, j+k,nums);
            }
        }
    }

    private static void swap(int j, int i, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
