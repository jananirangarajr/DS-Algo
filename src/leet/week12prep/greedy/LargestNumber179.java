package leet.week12prep.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber179 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
    public static String largestNumber(int[] nums) {
        //convert integer array to nums
        String[] strNums = Arrays.stream(nums).mapToObj(x -> String.valueOf(x)).toArray(String[]::new);
        Arrays.sort(strNums, (String s1, String s2) -> (s2+s1).compareTo(s1+s2));
        String result = Arrays.stream(strNums).reduce((x,y) -> x.equals("0")?y:x+y).get();
        return result;
    }
}
