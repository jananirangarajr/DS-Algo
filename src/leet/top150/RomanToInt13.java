package leet.top150;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;

public class RomanToInt13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum = 0;
//        CharacterIterator it = new StringCharacterIterator(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // special cases for 4,9,40,90,400,900
            if (c == 'V' || c == 'X' ) {
                if (i>0 && s.charAt(i-1) == 'I')
                    sum -=2;
            }
            if(c == 'L' || c == 'C' ){
                if (i>0 && s.charAt(i-1) == 'X')
                    sum -=20;
            }
            if(c =='D' || c=='M'){
                if (i>0 && s.charAt(i-1) == 'C')
                    sum -=200;
            }
            sum+=map.get(c);
        }
        return sum;
    }
}
