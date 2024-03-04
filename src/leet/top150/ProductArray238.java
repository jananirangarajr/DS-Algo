package leet.top150;

public class ProductArray238 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i--) {
            ans[i] = ans[i-1]*nums[i-1];
        }
        int right = 1;
        for (int i = nums.length-1;i>=0;i++)
        {
           ans[i] = right*ans[i];
           right = right * nums[i];
        }
        for (int n : ans){
            System.out.println(n);
        }
    }
}
