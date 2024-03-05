package algo.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,4,5,6,7,8,9};
        int index = binarySearch(nums,9,0,nums.length-1);
//        boolean found = binarySearch(nums,10,0,nums.length-1);
//        System.out.println(found);
        System.out.println(index);
    }

//    private static boolean binarySearch(int[] nums, int key, int left, int right) {
//        if (nums[left] == key) return true;
//        if (nums[right] == key) return true;
//        if (left == right) return false;
//        else {
//                int mid = (left+right)/2;
//                if (key <= nums[mid])
//                    return binarySearch(nums,key,left,mid);
//                else
//                return binarySearch(nums, key, mid+1, right);
//        }
//    }
    private static int binarySearch(int[] nums, int key, int left, int right) {
        if (nums[left] == key) return left;
        if (nums[right] == key) return right;
        if (left == right && nums[right] != key) return -1;
        else {
            int mid = (left+right)/2;
            if (key <= nums[mid])
                return binarySearch(nums,key,left,mid);
            else
                return binarySearch(nums,key,mid+1,right);
        }
    }
}
