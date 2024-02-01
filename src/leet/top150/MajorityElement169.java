package leet.top150;

import java.util.*;

public class MajorityElement169 {
    public static void main(String[] args) {

        int[] nums = new int[] {1,3,2,3,3,2};

//        int n = majorityElemenet(nums);
//        System.out.println(n);
        int count = 0;
        int currentElement = -123;

        for (int i = 0 ; i < nums.length; i++){
            if (count == 0)
                currentElement = nums[i];
            if (currentElement == nums[i])
                count++;
            else
                count--;
        }
        System.out.println(currentElement);
        
    }

    private static int majorityElemenet(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        else {
            /*HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num))
                    map.put(num,map.get(num)+1);
                else
                    map.put(num,0);
            }
            int maxCount = 0;
            int num = 0;
            for (Map.Entry entry: map.entrySet()){
                if (maxCount < (int) entry.getValue()) {
                    maxCount = (int)entry.getValue();
                    num = (int) entry.getKey();
                }
            }
            return num;*/
            /*Arrays.sort(nums);
            int maxCount = 0;
            int element = 0;
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[j-1]) {
                    int count = j - i;
                    if (count > maxCount) {
                        i = j;
                    }
                }
            }
            return element;*/
            return 0;
        }
    }
}
