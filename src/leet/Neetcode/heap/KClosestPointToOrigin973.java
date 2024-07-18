package leet.Neetcode.heap;

import java.util.PriorityQueue;

public class KClosestPointToOrigin973 {
    public static void main(String[] args) {
        int[][] array = {{3,3},{5,-1},{-2,4}};
        int[][] result = kClosest(array,2);
        for (int[] x : result){
            System.out.println(x[0]+" "+x[1]);
        }
    }
    static class Pair {
        Integer index;
        Integer dist;
        Pair(int i, int d){
            this.index = i;
            this.dist = d;
        }
    }
    public static int[][] kClosest(int[][] points, int k) {
//        PriorityQueue<Pair> queue = new PriorityQueue<>((x, y) -> y.dist - x.dist);
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) ->((x[0] * x[0]) + (x[1] * x[1])) - ((y[0] * y[0]) - (y[1] * y[1])));

        for (int i = 0; i < points.length; i++){
//            queue.add(new Pair(i, (points[i][0] * points[i][0]) + (points[i][1] * points[i][1])));
            queue.add(points[i]);
            if (queue.size() > k)
                queue.poll();
        }
        int[][] result = new int[queue.size()][2];
        int i = 0;
       for (int[] p : queue){
           result[i++] = p;
       }
//       for (Pair p : queue){
//           result[i++] = points[p.index];
//       }
       return result;
    }
}
