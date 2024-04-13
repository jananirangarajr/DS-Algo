package leet.week12prep.stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision735 {
    public static void main(String[] args) {
//        int[] asteroids = new int[] {-2,-2,1,-2};
        int[] asteroids = new int[] {-2,-2};
        int[] result = asteroidCollision(asteroids);
        Arrays.stream(result).forEach(System.out::println);
    }
    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

       /* for (int x : asteroids){
                if (stack.isEmpty() || (stack.peek() > 0) && x > 0 || (stack.peek() < 0 && x < 0) || (stack.peek() < 0 && x > 0))
                    stack.push(x);
                else {
                    while (!stack.isEmpty() && x != 0) {
                        if (stack.peek() + x == 0) {
                            stack.pop();
                            x = 0;
                        } else if (stack.peek() + x > 0) {
                            x = 0;
                        } else
                            stack.pop();
                    }
                    if (x != 0)
                        stack.push(x);
                }

        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
*/
        int n = asteroids.length;

        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(asteroids[i] > 0 || s.empty()) {
                s.push(asteroids[i]);
            }
            else {
                while(!s.empty() && s.peek() > 0 && s.peek() < Math.abs(asteroids[i])) {
                    s.pop();
                }
                if(!s.empty() && s.peek() == Math.abs(asteroids[i])) {
                    s.pop();
                }
                else {
                    if(s.empty() || s.peek() < 0) {
                        s.push(asteroids[i]);
                    }
                }
            }
        }
        return s.stream().mapToInt(Integer::intValue).toArray();
    }
}
