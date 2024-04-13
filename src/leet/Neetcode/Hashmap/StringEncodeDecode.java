package leet.Neetcode.Hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringEncodeDecode {
    public static void main(String[] args) {
        String[] input = {"neet","code","love","you"};
        List<String> strs = Arrays.asList(input);
        String encodedStr = encode(strs);
        System.out.println(encodedStr);
        System.out.println(decode(encodedStr));
    }
    public static String encode(List<String> strs) {

        String encodedStr = "";

        for (String s : strs) {
            encodedStr += s.length()+"#"+s;
        }
        return encodedStr;
    }

    public static List<String> decode(String str) {

        List<String> result = new ArrayList<String>();

        for (int i = 0; i < str.length(); ) {
            int length = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (str.charAt(i+1) == '#'){
                result.add(str.substring(i+2, i+2+length));
                i = i+2+length;
            }
        }
        return result;
    }
}
