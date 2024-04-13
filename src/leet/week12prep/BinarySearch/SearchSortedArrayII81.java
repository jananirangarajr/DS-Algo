package leet.week12prep.BinarySearch;

public class SearchSortedArrayII81 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,1,1};
        int target = 0;
        System.out.println(search(nums,target));
    }
    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return true;
            //left array
            if (nums[mid] > nums[left]) {
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    if (target < nums[left])
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
            }
            else if (nums[mid] < nums[left]){
                if (target < nums[mid])
                    right = mid - 1;
                else if (target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else
                left = left+1;
        }
        return false;
    }
}
