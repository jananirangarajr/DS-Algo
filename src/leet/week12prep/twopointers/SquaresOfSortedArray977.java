package leet.week12prep.twopointers;

public class SquaresOfSortedArray977 {
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
        int[] result = sortedSquares(nums);
        for (int x : result)
            System.out.print(x+" ");
    }
    public static int[] sortedSquares(int[] nums) {
        //find the pointer starting from positive
        /*int startIndex = -1;
        int result[] = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < 0 && nums[i]>=0){
                startIndex = i;
            }
        }
        if (startIndex == -1) {
            calculateSquare(result, 0, nums.length, nums);
            if (nums[0] < 0)
                reverse(result);
        }
        else{
            int left[] = new int[startIndex];
            int right[] = new int[nums.length-startIndex];
            calculateSquare(left, 0,startIndex-1, nums);
            calculateSquare(right, startIndex,nums.length-1,nums);
            //merge left right
            int i =startIndex-1, j = 0,k = 0;
            while(i >= 0 || j < right.length){
                if (i >= 0 && left[i] <= right[j])
                {
                    result[k++] = left[i];
                    i--;
                }
                else if (j < right.length){
                    result[k++] = right[j];
                    j++;
                }
            }
        }
        return result;*/

        int[] result = new int[nums.length];
        int i = 0, j = nums.length-1,k = nums.length-1;
        while (i <= j){
            System.out.println(i+" "+j);
            if (i < nums.length && Math.abs(nums[i]) > Math.abs(nums[j])){
                result[k--] = nums[i] * nums[i];
                i++;
            }
            else {
                result[k--] = nums[j]* nums[j];
                j--;
            }
        }
        return result;
    }

   /* private static void reverse(int[] result) {
        int i = 0, j = result.length-1;
        while(i <= j){
            int temp = result[i];
            result[i++] = result[j];
            result[j--] = temp;
        }
    }

    private static void calculateSquare(int[] result, int left, int right,int[] nums){
        int i = 0, j = result.length-1;
        while (left <= right) {
            result[i++] = nums[left] * nums[left];
            result[j--] = nums[right] * nums[right];
            left++;
            right--;
        }
    }*/
}
