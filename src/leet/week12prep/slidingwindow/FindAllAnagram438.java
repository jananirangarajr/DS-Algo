package leet.week12prep.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagram438 {
    public static void main(String[] args) {
        String s = "text";
        String p ="ex";
        System.out.println(findAnagrams(s,p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (pLen > sLen || s.length() == 0 ||p.length() == 0)
            return new ArrayList<>();
        // the character array values increment for second string character value
        //the character Array values decrements for first string character value
        //logic : increment the counter if the char of P not found in S,
        //decrement if it is found,
        //while moving the start pointer to contract the window, increment it
        //decrement while moving end pointer when expanding the window.
        List<Integer> result = new ArrayList<>();

        int start =0, end = 0, count = p.length(); //count maintains the count of the characters in second string P
        int[] charArr = new int[26];//values corresponding to the s will be in negative and positive values for p.

        //compute first window always
        for (int i =0; i < pLen; i ++){
            char c = p.charAt(i);
            charArr[c-'a'] += 1;
        }
        //move end to the end of the window
        for (end = 0; end < pLen; end++){
            char c = s.charAt(end);
            charArr[c-'a'] -=1;
            if (charArr[c-'a'] >= 0)
                count--;
        }
        //if the count of characters equal, then

        if (count == 0)
            result.add(start);

        while(end <sLen) {
            //move start
            char c = s.charAt(start);
            if (charArr[c-'a'] >= 0) {
                count++; // add the character to the count first
            }
            charArr[c-'a'] +=1;
            start++;

            //move end
            c = s.charAt(end);
            charArr[c-'a'] -=1;
            if (charArr[c-'a'] >= 0)
                count--;

            if (count == 0)
                result.add(start);
            end++;
        }
        return result;
    }
}
