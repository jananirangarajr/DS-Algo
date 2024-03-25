package leet.week12prep.BinarySearch;

public class SearchSortedArray33 {
    public static void main(String[] args) {
        int[] nums = new int[] {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {

        int left = 0, right = nums.length-1;

        while(left <= right){
            int mid = left+(right - left)/2;
            if (nums[mid] == target)
                return mid;
            //left array
            if (nums[mid] >= nums[left]) {
                if (target > nums[mid]) {
                    left = mid+1;
                }
                else{
                    if (target < nums[left])
                        left = mid+1;
                    else
                        right = mid-1;
                }
            }
            else {
                if (target < nums[mid])
                    right = mid -1;
                else
                if (target <= nums[right])
                    left = mid + 1;
                else
                    right = mid -1 ;
            }
        }
        return -1;

    }
}
