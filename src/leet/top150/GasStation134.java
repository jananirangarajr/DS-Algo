package leet.top150;

public class GasStation134 {
    public static void main(String[] args) {
        int[] gas = new int[] {3,1,1};
        int[] cost = new int[] {1,2,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        /*int totalCost = 0;
        int totalGas = 0;
        int highestGasIndex = 0;
        int highestGas = -1;
        for (int i = 0 ; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
            if (highestGas < gas[i] - cost[i]) {
                highestGasIndex = i;
                highestGas = gas[i] - cost[i];
            }
        }
        //System.out.println(totalGas+" "+totalCost);
        return totalGas >= totalCost?highestGasIndex:-1;
        Greedy approach - passed 32/40 testcases, didn't work - sample test case [gas - 5,8,2,8 cost - 6,5,6,6]
        */
        /*int totalCost = 0;
        int totalGas = 0;
        boolean[] possibleStartIndex = new boolean[gas.length];
        for (int i = 0; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
            possibleStartIndex[i] = gas[i] - cost[i] >= 0 ? true: false;
        }
        if (totalGas < totalCost)
            return -1;
        else {
            for (int i = 0 ;i < possibleStartIndex.length; i++) {
                if (possibleStartIndex[i]){
                    int result = canCompleteCircuit(gas,cost,gas[i]-cost[i],i,i+1);
                    if (result > -1)
                        return result;
                }
            }
        }
        return -1;
        passed all testcases, but poor run time
        */

        /*for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                int result = canCompleteCircuit(gas, cost, gas[i] - cost[i], i, i + 1);
                if (result > -1)
                    return result;
            }
        }
        //passes all testcase, poor run time
        return -1;*/

        int totalCost = 0;
        int totalGas = 0;
        int currentcost = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas+= gas[i];
            totalCost+= cost[i];
            currentcost+= gas[i]- cost[i];
            if (currentcost <= 0) {
                startIndex = i+1;
                currentcost = 0;
            }
        }
        return totalGas >= totalCost?startIndex:-1;
    }

    private static int canCompleteCircuit(int[] gas, int[] cost, int tankCapacity, int start, int end) {
        if (end == gas.length)
            end = 0;
        if (tankCapacity <= 0 && start != end)
            return -1;
        if (start == end)
            if (tankCapacity >= 0)
                return start;
            else
                return -1;
        if (tankCapacity+gas[end]-cost[end] < 0)
            return -1;
        return canCompleteCircuit(gas, cost, tankCapacity+gas[end]-cost[end], start, end + 1);
    }
}
