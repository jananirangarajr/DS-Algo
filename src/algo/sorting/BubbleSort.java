package algo.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[] {3,5,6,2,0,1};

        for (int i = 1; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        for (int n : nums)
            System.out.println(n);
    }
}
