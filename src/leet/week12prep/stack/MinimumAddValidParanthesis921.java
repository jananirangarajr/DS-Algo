package leet.week12prep.stack;

import java.util.Stack;

public class MinimumAddValidParanthesis921 {
    public static void main(String[] args) {
        String s = ")(";
        System.out.println(minAddToMakeValid(s));
    }
    public static int minAddToMakeValid(String s) {

        /*Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(c);
            }
            else
                stack.push(c);
        }
        return stack.size();*/

        int unmatchedOpen = 0;
//        int unmatchedClose= 0;
        for (int i = 0; i < s.length();i++) {
            char c = s.charAt(i);
            if (c == '(')
                unmatchedOpen++;
            else {
//                if (unmatchedOpen > 0)
                    unmatchedOpen--;
//                else
//                    unmatchedClose++;
            }
        }
//        return unmatchedClose+unmatchedOpen;
        return Math.abs(unmatchedOpen);
//won' work for cases )(
    }
}
