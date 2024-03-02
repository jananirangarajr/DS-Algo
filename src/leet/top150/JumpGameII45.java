package leet.top150;

public class JumpGameII45 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,5};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {

       /* Greedy approach didn't work, minimum doesn't depend on the max value. It depends on which gives minimum among the possibility
       failed input 7,0,9,6,9,6,1,7,9,0,1,2,9,0,3 returns 4 actual output 2
       if (nums.length == 1)
            return 0;
        int count = 1;
        int maxReach = nums[0];
        for (int i = 1; i < nums.length;i++) {
            if (maxReach >= nums.length-1)
                return count;
            if (i+nums[i] > maxReach) {
                maxReach = i+nums[i];
                count++;
            }
        }
        return count;*/
        /*
        DP tabulation method, worked
        if (nums.length == 1)
            return 0;
        else {
            int countArr[] = new int[nums.length];
            for (int index = nums.length-2; index >=0; index--) {
                if (nums[index] == 0) {
                    countArr[index] = Integer.MAX_VALUE;
                }
                else if (index+nums[index] >= nums.length) {
                    countArr[index] = 1;
                }
                else {
                    int min = Integer.MAX_VALUE;
                    for (int i = index+1; i <= index+nums[index]; i++) {
                        if (min > countArr[i])
                            min = countArr[i];
                    }
                    countArr[index] = min == Integer.MAX_VALUE?min:min+1;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                System.out.println(countArr[i]);
            }
            return countArr[0];
        }*/
        //o(n) optimized solution, Greedy approach
        int jump = 0;
        int endIndex = 0;
        int farthestIndexAtI = 0;
        for (int i = 0; i < nums.length-1; i++) {
            farthestIndexAtI = Math.max(farthestIndexAtI, i+nums[i]);
            if (endIndex == i) {
                jump++;
                endIndex = farthestIndexAtI;
            }
        }
        return jump;
        //return jump(nums,0);
    }
    public static int jump(int[] nums, int index) {
        if (index >= nums.length || index+nums[index] >= nums.length)
            return 0;
        if (nums[index] == 0)
            return Integer.MAX_VALUE;
        int currentMaxJumpCount = Integer.MAX_VALUE;
        for (int i = index+1; i <= nums[index]+index; i++) {
            currentMaxJumpCount = Math.min(currentMaxJumpCount, 1+jump(nums,i));
        }
        return currentMaxJumpCount;
    }
}
