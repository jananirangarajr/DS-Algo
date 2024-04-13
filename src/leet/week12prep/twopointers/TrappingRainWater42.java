package leet.week12prep.twopointers;

public class TrappingRainWater42 {
    public static void main(String[] args) {
        int[] heights = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }
    public static int trap(int[] height) {
        //basic formula => for every i, the water storage capacity is Min(left of i , right of i) - height[i]
        //intution here is, for every i, calculate with comparing either Maxleft of i or with Maxright of the i => because
        //by checking condition that height[left] <= height[right] we are making sure that i has other side that is greater than the considering left/right side that is considered
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = n-1;
        int total = 0;
        while( left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax)
                    leftMax = height[left];
                else {
                    total += leftMax - height[left];
                }
                left++;
            }
            else{
                if (height[right] >= rightMax){
                    rightMax = height[right];
                }
                else{
                    total += rightMax - height[right];
                }
                right--;
            }
        }
        return total;
    }
}
