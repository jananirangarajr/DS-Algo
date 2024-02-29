package leet.top150;

public class RemoveDuplicateSortedArray80 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,3};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        else {
            int k = 2;
            for (int i = k; i < nums.length; i++) {
                if (nums[k] == nums[k-2] && nums[k] != nums[i]) {
                    nums[k++] = nums[i];
                }
                else if (nums[k] != nums[k-2])
                    k++;

            }
            return k;
        }
    }
}
