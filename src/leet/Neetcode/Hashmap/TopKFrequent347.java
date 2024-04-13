package leet.Neetcode.Hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequent347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3};
        int k = 2;
        int[] result = topKFrequent(nums,k);
        Arrays.stream(result).forEach(System.out::println);
    }
    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            map.putIfAbsent(nums[i],0);
            int count = map.get(nums[i]);
            map.put(nums[i],count+1);
        }

        List<Integer>[] freqBucket = new List[nums.length+1];

        for (int x: map.keySet()){
            if (freqBucket[map.get(x)] == null) {
                freqBucket[map.get(x)] = new ArrayList<>();
            }
            freqBucket[map.get(x)].add(x);
        }
        List<Integer> result = new ArrayList<>();
        for (int i =  freqBucket.length-1; i >= 0 ;i--) {
            if (freqBucket[i] != null){
                if (freqBucket.length < k){
                    result.addAll(freqBucket[i]);
                    k -= freqBucket[i].size();
                }
                else if (k != 0){
                    result.addAll(freqBucket[i].subList(0,k));
                    k = 0;
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
