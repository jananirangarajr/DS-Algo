package leet.top150;

import java.util.Stack;

public class ValidParanthesis20 {
    public static void main(String[] args) {
        String s = "{}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        if (s.length() == 1)
            return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else {
                if (stack.isEmpty())
                    return false;
                char top = stack.peek();
                if ((top == '(' && s.charAt(i) == ')') || (top == '{' && s.charAt(i) == '}')
                || (top == '[' && s.charAt(i) == ']'))
                    stack.pop();
                else
                    return false;
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}
