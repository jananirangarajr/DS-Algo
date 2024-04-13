package leet.week12prep.stack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals56 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{8,10},{15,18},{2,6}};

        int[][] result = merge(intervals);
        Arrays.stream(result).toList().forEach(x -> System.out.println(x[0]+" "+x[1]));
    }
    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();

        Arrays.sort(intervals,(i1,i2) -> Integer.compare(i1[0],i2[0]));

//        Arrays.stream(intervals).toList().forEach(x -> System.out.println(x[0]+" "+x[1]));
        result.add(intervals[0]);

        int index = 0;
        for (int i = 1; i < intervals.length;i++) {
            if (intervals[i][0] <= result.get(index)[1]){
                result.get(index)[1] = Math.max(intervals[i][1],result.get(index)[1]);
            }
            else {
                result.add(intervals[i]);
                index++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
