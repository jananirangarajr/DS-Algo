package leet.week12prep.BinarySearch;

public class FindMinimumInSortedRotatedArray153 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        /*int left = 0, right = nums.length-1;
        //size of 1 0r 2
        if (nums.length <= 2)
            if (nums.length == 1)
                return nums[0];
            else
                return nums[0] > nums[1]?nums[1]:nums[0];

        int mid = left+(right-left)/2;
        // not rotated or rotated n times
        if (nums[mid] >  nums[left] && nums[mid] < nums[right])
            return nums[0];
        //left sorted array
        if (nums[mid] > nums[left])
            left = mid;
            //right sorted array
        else
            right = mid;
        int result = nums[left];
        while (left < right) {
            if (result > nums[left+1])
                result = nums[left+1];
            left++;
        }
        return result;*/
        //better approach
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left+(right-left)/2;
            if (nums[mid] > nums[right])
                left = mid+1;
            else
                right = mid;
        }
        return nums[left];
    }
}
