package leet.top150;

import java.util.HashMap;

public class IntegerToRoman12 {
    public static void main(String[] args) {
        int num = 2779;
        System.out.println(intToRoman(num));
    }
    public static String intToRoman(int num) {
        String result = "";
        int index = 0;
        HashMap map = new HashMap();
        map.put(1,"I");
//        map.put(2,"II");
//        map.put(3,"III");
        map.put(4,"IV");
        map.put(5,"V");
//        map.put(6,"VI");
//        map.put(7,"VII");
//        map.put(8,"VIII");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
//        while(num > 0){
//            int x = num%10;
//            num = num/10;
//            if (x != 0) {
//                System.out.println((int)x*(Math.pow(10,index)));
//                if (map.containsKey((int)(x*(Math.pow(10,index)))))
//                    result = map.get((int)(x*(Math.pow(10,index)))) + result;
//                else {
//                    String roman = "";
//                    while(x > 0){
//                        int lowest = x>5 ? 5 : 1;
//                        x = x-lowest;
//                        lowest = (int) (lowest*Math.pow(10,index));
//                        roman =roman + map.get(lowest);
//                    }
//                    result = roman+result;
//
//                }
//            }
//            index++;
//        }
        //more optimized technique
        int[] values = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = new String[] {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
//        String result="";
        for (int i = 0; i < values.length; i++) {
            while (values[i] <= num){
                result = result + roman[i];
                num -= values[i];
            }
        }
        return result;
    }
}
