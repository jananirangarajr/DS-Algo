package leet.week12prep.twopointers;

public class BackspaceStringCompare844 {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "bd#c";
        System.out.println(backspaceCompare(s,t));
    }
    public static boolean backspaceCompare(String s, String t) {
        int i = s.length()-1, j = t.length()-1, backSlash = 0;
        while(i >=0 || j >= 0) {
           i = nextValid(s,i) ;
           j = nextValid(t,j);
           char s_c = i >=0 ? s.charAt(i):'/';
           char t_c = j >=0 ? t.charAt(j):'/';
           if (s_c != t_c)
               return false;
           i--;
           j--;
        }
        return true;
    }

    private static int nextValid (String s, int index) {
        int backspaces = 0;
        while(index >=0) {
            if (backspaces == 0 && s.charAt(index) != '#')
                return index;
            else if (s.charAt(index) == '#')
                backspaces += 1;
            else
                backspaces -= 1;
            index--;
        }
        return index;
    }
}
