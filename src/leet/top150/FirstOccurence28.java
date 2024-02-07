package leet.top150;

public class FirstOccurence28 {
    public static void main(String[] args) {
        String haystack = "aabaaabaaac";
        String needle = "aabaaac";
        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        /*int i = 0, j = 0;
        while(j < needle.length() && i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
            }
            else {
                if (j == 0 && haystack.charAt(i) != needle.charAt(j)) {
                    i++;
                }
                else if (j > 0 && haystack.charAt(i) != needle.charAt(j-1)) {
                    i++; j = 0;
                }
                else {
                    i = i - j + 1;
                    j = 0;
                }
            }
        }

        return j == needle.length() ? i - j:-1;
        failed at mississippi => issip
        */
        //a a b a a a b a a a c  aabaaac
        //0 1 2 3 4 5 6 7 8 9 10
        int i = 0, j = 0;
        boolean firstletterSeenBefore = false;
        int startingIndex = 0;
        while(j < needle.length() && i < haystack.length()) {
//            if (haystack.length()- i < needle.length()){
//                return -1;
//            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j != 0 && haystack.charAt(i) == needle.charAt(0) && !firstletterSeenBefore) {
                    firstletterSeenBefore = true;
                    startingIndex = i;
                }
                i++; j++;
            }
            else {
                if (j == 0) {
                    i++;
                }
                else if ( j > 0 && firstletterSeenBefore) {
                    j = 0;
                    i = startingIndex;
                    firstletterSeenBefore = false;
                }
                else {
                    j = 0;
                }
            }
        }

        return j == needle.length() ? i - j:-1;

    }
}
