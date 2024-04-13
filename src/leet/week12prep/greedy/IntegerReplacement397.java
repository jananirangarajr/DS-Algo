package leet.week12prep.greedy;

import java.util.HashMap;

public class IntegerReplacement397 {
    public static void main(String[] args) {
        int n = 7;
//        int count = 0;
//        while(n > 1){
//            if (n % 2 == 0){
//                n = n/2;
//            }
//            else {
//                n = n - 1;
//            }
//            count++;
//        }
//        System.out.println(count);
        //only one choice is made of odd n-1. Some cases exists that n+1 might be the best choice

        //DP solution
        HashMap<Long,Integer> map = new HashMap<>();
        System.out.println(compute(map,n));
    }
    private static int compute(HashMap<Long,Integer> map, long n){
        if (n <= 1)
            return 0;
        else{
            if(!map.containsKey(n)){
                if (n % 2 == 0) {
                    map.put(n, 1 + compute(map, n / 2));
                }
                else{
                    map.put(n, 1+Math.min(compute(map,n+1),compute(map,n-1)));
                }
            }
            return map.get(n);
        }
    }
}
