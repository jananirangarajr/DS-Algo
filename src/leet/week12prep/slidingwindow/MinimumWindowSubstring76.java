package leet.week12prep.slidingwindow;

public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        int start = 0, count = t.length();
        char[] arr = new char[128];
        int minLength=Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < t.length(); i++){
            arr[t.charAt(i)] +=1;
        }

        for(int end= 0; end < s.length(); end++){
            arr[s.charAt(end)] -=1;
            if (arr[s.charAt(end)] >= 0)
                count --;
           while (count == 0){
                if (end-start < minLength){
                    minLength = end-start;
                    minIndex = start;
                }
                arr[s.charAt(start)] += 1;
           }
        }
        return minLength==Integer.MAX_VALUE?"":s.substring(minIndex,minIndex+minLength);
    }
}
