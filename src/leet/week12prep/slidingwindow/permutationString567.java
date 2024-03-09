package leet.week12prep.slidingwindow;

public class permutationString567 {
    public static void main(String[] args) {
        String s1 = "eidbaooo";
        String s2 = "ab";
        System.out.println(checkInclusion(s1,s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len == 0 || s2Len == 0 || s2Len < s1Len)
            return false;

        int start = 0, end = 0, count = s1Len;
        int[] arr = new int[26];
        char c;
        for (int i = 0; i < s1Len; i++) {
            c = s1.charAt(i);
            arr[c-'a'] +=1;
        }
        for (end = 0; end < s1Len; end++) {
            c = s2.charAt(end);
            if (arr[c-'a'] >= 0) {
                arr[c-'a'] -=1;
                count--;
            }
        }
        if (count == 0)
            return true;
        while(end < s2Len) {
            // contract the window
            c = s2.charAt(start);
            if (arr[c-'a'] >= 0) {
                count++;
            }
            arr[c-'a'] +=1;
            start++;

            //expand the window
            c = s2.charAt(end);
            arr[c-'a'] -=1;
            if (arr[c-'a'] >= 0)
                count--;
            end++;
            if (count == 0)
                return true;

        }
        return false;
    }
}
