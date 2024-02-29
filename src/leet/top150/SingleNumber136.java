package leet.top150;

public class SingleNumber136 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,1,2,3,8};
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        System.out.println(result);
    }
}
