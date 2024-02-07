package leet.top150;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1)
            return true;
        else {
            /*for (int i = 0, j =s.length()-1; i < j; i++, j-- ){

                while ( i < s.length() && !(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))) {
                    i++;
                }
                while (j > 0 && !(Character.isDigit(s.charAt(j)) || Character.isLetter(s.charAt(j)))) {
                    j--;
                }
                if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                    return false;
            }*/
            //another approach
            int start = 0;
            int last = s.length()-1;
            while(start<last){
                if (!(Character.isDigit(s.charAt(start)) || Character.isLetter(s.charAt(start)))) {
                    start++;
                }
                else if (!(Character.isDigit(s.charAt(last)) || Character.isLetter(s.charAt(last)))) {
                    last--;
                }
                else {
                    if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(last)))
                        return false;
                    start++;
                    last--;
                }
            }
        }
        return true;
    }
}
