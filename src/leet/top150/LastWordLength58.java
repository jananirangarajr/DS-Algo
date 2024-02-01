package leet.top150;

public class LastWordLength58 {
    public static void main(String[] args) {
        String s= " sat  in   the   wall   ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
//        System.out.println(s);
        int n = s.length();
        int i = n-1;
        for (; i >=0; i--) {
            if (s.charAt(i) == ' '){
                break;
            }
        }
        return i < 0 ? n : n-1-i;
    }
}
