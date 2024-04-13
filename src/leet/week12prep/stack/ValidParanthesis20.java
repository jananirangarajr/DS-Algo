package leet.week12prep.stack;

import java.util.Stack;

public class ValidParanthesis20 {
    public static void main(String[] args) {
        String s = "[({})";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        if (s.length() == 1)
            return false;
        else{
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < s.length();i++){
                char c = s.charAt(i);
                if (c == '(')
                    stack.push(')');
                else if (c == '{')
                    stack.push('}');
                else if (c == '[')
                    stack.push(']');
                else if(stack.isEmpty() || stack.pop() != c)
                    return false;
            }
            return stack.isEmpty()?true:false;
        }
    }
}
