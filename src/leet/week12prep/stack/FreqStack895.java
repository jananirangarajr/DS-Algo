package leet.week12prep.stack;

import java.util.HashMap;
import java.util.Stack;

public class FreqStack895 {
        HashMap<Integer,Integer> freqmap = new HashMap<>();
        HashMap<Integer, Stack<Integer>> stackMap = new HashMap<Integer, Stack<Integer>>();
        int maxFreq = 0;

        public FreqStack895() {

        }

        public void push(int val) {
            int freqCount = 0;
            if (freqmap.containsKey(val)) {
                freqCount = freqmap.get(val);
            }
            freqCount++;
            freqmap.put(val,freqCount);
            maxFreq = Math.max(freqCount,maxFreq);
            if(stackMap.containsKey(maxFreq)){
                stackMap.get(maxFreq).push(val);
            }
            else{
                stackMap.put(freqCount,new Stack<>());
                stackMap.get(freqCount).push(val);
            }
            System.out.println(freqmap.get(val));
            System.out.println(stackMap.get(freqCount));
        }

        public int pop() {
            int val = stackMap.get(maxFreq).pop();
            if (stackMap.get(maxFreq).isEmpty())
                maxFreq -= 1;
            freqmap.put(val,freqmap.get(val)-1);
            return val;
        }

    public static void main(String[] args) {
        FreqStack895 freqStack = new FreqStack895();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        freqStack.pop();
    }
}
