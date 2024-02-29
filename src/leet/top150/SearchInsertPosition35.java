package leet.top150;

public class SearchInsertPosition35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4};
        int target = 3;
        System.out.println(searchInsert(nums,target));
    }
    public static int searchInsert(int[] nums, int target) {
        int mid = nums.length/2;
        if (target == nums[mid])
            return mid;
        else if(nums.length == 1)
            return target < nums[0] ? 0 : 1;
        else if (target < nums[mid]) {
            for (int i = 0; i < mid-1; i++){
                if (target <= nums[i])
                    return i;
            }
        }
        else {
            for (int i = mid+1; i < nums.length; i++){
                if (nums[i] >= target)
                    return i;
            }
        }
        return nums.length;
    }
}
