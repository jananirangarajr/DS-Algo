package leet.week12prep.backtracking;

import java.util.*;
public class GenerateParanthesis22 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n,result,"",0,0);
        return result;
    }

    private static void generateParenthesis(int n, List<String> result, String output, int open, int close) {
        if( output.length() == 2 * n)
        {
            result.add(output);
            return;
        }
        else {
            if (open < n) {
                generateParenthesis(n,result,output+"(",open+1, close);
            }
            if (close < open) {
                generateParenthesis(n, result, output+")",open, close+1);
            }
        }
    }
}
