package leet.week12prep.greedy;

import java.util.ArrayList;

public class ValidTriangleNumber611 {
    public static void main(String[] args) {
        int[] nums = new int[] {4,2,3,4};
        System.out.println(triangleNumber(nums));
    }
    public static int triangleNumber(int[] nums) {
        return triangleNumber(nums,new ArrayList<Integer>(),0,0);
    }

    private static int triangleNumber(int[] nums, ArrayList<Integer> list, int count, int index) {
        if (list.size() == 3){
            if (list.get(0)+list.get(1) > list.get(2) && list.get(0)+list.get(2) > list.get(1) && list.get(2)+list.get(1) > list.get(0))
                return count+1;
            return count;
        }
        else {
            for (int i = index; i < nums.length; i++){
                list.add(nums[i]);
                count = triangleNumber(nums,list,count,i+1);
                list.remove(list.size()-1);
            }
            return count;
        }
    }
}
