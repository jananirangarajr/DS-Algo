package leet.top150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicatesII219 {
    public static void main(String[] args) {
        int nums[] = new int[] {1,2,3,1,2,3};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums,k));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        /*HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i])-i) <= k)
                    return true;
                map.put(nums[i],i);
            }
            else
                map.put(nums[i],i);
        }
        return false;*/
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                return true;
            if (i >= k)
                set.remove(nums[i-k]);

        }
        return false;

    }
}
