package leet.week12prep.slidingwindow;

public class SubString3DistinctCharacter1876 {
    public static void main(String[] args) {
        String s= "aababcabc";
        System.out.println(countGoodSubstrings(s));
    }
    public static int countGoodSubstrings(String s) {
        if (s.length() < 3)
            return 0;
//        int length = 3;
//        int start = 0, end = 0, count = length, result = 0;
//        char arr[] = new char[26];
//        char c;
//        for (;end < length; end++){
//            c = s.charAt(end);
//            if (arr[c-'a'] == 0)
//                count --;
//            arr[c-'a'] +=1;
//        }
//        if (count == 0)
//            result++;
//        while(end < s.length()) {
//            c = s.charAt(start);
//            if (arr[c-'a'] == 1)
//                count++;
//            arr[c-'a'] -=1;
//            start++;
//
//            c= s.charAt(end);
//            if (arr[c-'a'] == 0)
//                count--;
//            arr[c-'a'] += 1;
//            end++;
//            if (count == 0)
//                result++;
//        }
//        return result;
//    }
        char a = s.charAt(0), b = s.charAt(1), c = s.charAt(2);
        int length = 3, count = 0;
        for (int i = length; i < s.length(); i++) {
            if (a != b && b != c && c != a)
                count++;
            a = b;
            b = c;
            c = s.charAt(i);
        }
        if (a != b && b != c && c != a)
            count++;
        return count;
    }

}
