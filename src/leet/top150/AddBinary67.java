package leet.top150;

public class AddBinary67 {
    public static void main(String[] args) {
        String a = "101111";
        String b = "10";

        /*int carry = 0;
        StringBuilder result = new StringBuilder("");
        for (int i = a.length()-1, j = b.length()-1; i >= 0 || j >=0; i--,j--) {
            if (i >=0 && j >=0 ) {
                if (a.charAt(i) == '1' && b.charAt(j) =='1')
                {
                    if (carry == 1)
                        result.append('1');
                    else{
                        carry = 1;
                        result.append('0');
                    }
                }
                else {
                    if (a.charAt(i) == '0' && b.charAt(j) =='0') {
                        result.append(carry);
                        carry = 0;
                    }
                    else if (carry == 1)
                        result.append('0');
                    else
                        result.append('1');
                }
            }
            else if (j >=0){
                if (carry == 1 && b.charAt(j) == '1')
                    result.append(0);
                else{
                    if (carry ==0)
                        result.append(b.charAt(j));
                    else if (b.charAt(j) == '0') {
                        result.append('1');
                    }
                }
            }
            else if (i >=0){
                if (carry == 1 && a.charAt(i) == '1')
                    result.append(0);
                else{
                    if (carry ==0)
                        result.append(a.charAt(i));
                    else if (a.charAt(i) == '0') {
                        result.append('1');
                    }
                }
            }
        }
        if (carry == 1)
            result.append(1);
        System.out.println(result.reverse().toString());*/
        //Another bit wise approach
        int carry = 0;

        StringBuilder result = new StringBuilder("");
        for (int i = a.length()-1, j = b.length()-1; i >= 0 || j >=0|| carry != 0; i--,j--) {
            int bitA = i >=0? a.charAt(i)-'0': 0;
            int bitB = j >=0? b.charAt(j)-'0': 0;
            result.append(bitA ^ bitB^ carry);
            carry =(bitA & bitB) | (carry & bitA) | (carry & bitB);
        }
        System.out.println( result.reverse().toString());

    }
}
