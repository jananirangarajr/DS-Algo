package leet.top150;

public class ClimbingStairs70 {
    public static void main(String[] args) {
        int[] arr = new int[46];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        System.out.println(climbStairs(45,arr));
    }
    public static int climbStairs(int n, int[] arr) {
        if (arr[n] != 0)
            return arr[n];
         arr[n] = climbStairs(n-1,arr)+climbStairs(n-2,arr);
         return arr[n];
    }

}
