package leet.week12prep.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement424 {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }
    public static int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, result = 0, maxfrequency = 1;
//        while(end < s.length())
//        {
//            if ((end - start)-maxfrequency < k) {
//                if (!map.containsKey(s.charAt(end))) {
//                    map.put(s.charAt(end), 1);
////                    maxfrequency = Math.max(1, maxfrequency);
//                } else {
//                    int letterFrequency = map.get(s.charAt(end));
//                    map.put(s.charAt(end), letterFrequency + 1);
////                    maxfrequency = Math.max(letterFrequency + 1, maxfrequency);
//                }
//                result = Math.max(result,(end-start+1));
//            }
//            else {
//                map.put(s.charAt(start),map.get(s.charAt(start))-1);
//            }
//            //iterate hashMap to find the maxFrequency everytime
//            for (Map.Entry e : map.entrySet()) {
//                System.out.print(e.getKey()+" "+e.getValue());
//                maxfrequency = Math.max(maxfrequency,(int)e.getValue());
//                System.out.println(" " +maxfrequency);
//            }
//            end++;
//        }
//        return result;
        /*for (; end < s.length(); end++){
            if (map.containsKey(s.charAt(end)))
                map.put(s.charAt(end),map.get(s.charAt(end))+1);
            else
                map.put(s.charAt(end),1);
            for (Map.Entry e : map.entrySet())
                maxfrequency= Math.max(maxfrequency,(int)e.getValue());
            while(end-start+1 - maxfrequency > k) {
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                start++;
            }

            result = Math.max(result, end-start+1);
        }
        return result;
        correct result, but changing map to charArray increases runtime a way more better.
        */
        char[] charArr = new char[26];
        for (; end < s.length(); end++){
            // if (map.containsKey(s.charAt(end)))
            //     map.put(s.charAt(end),map.get(s.charAt(end))+1);
            // else
            //     map.put(s.charAt(end),1);
            charArr[s.charAt(end)-'A'] +=1;
            // for (Map.Entry e : map.entrySet())
            //     maxfrequency= Math.max(maxfrequency,(int)e.getValue());
            for (int i = 0; i < 26; i++)
                maxfrequency= Math.max(maxfrequency,charArr[i]);
            while(end-start+1 - maxfrequency > k) {
                // map.put(s.charAt(start),map.get(s.charAt(start))-1);
                charArr[s.charAt(start)-'A'] -=1;
                start++;
            }

            result = Math.max(result, end-start+1);
        }
        /*Another small optimization for not iterating for max frequency everytime
        * whenever the character counter is increased check and update maxFrequency, not necessarily needed to decrement when the start is increased. - Not clear
        * */
        return result;
    }
}
