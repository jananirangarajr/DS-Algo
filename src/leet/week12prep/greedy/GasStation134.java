package leet.week12prep.greedy;

public class GasStation134 {
    public static void main(String[] args) {
        int[] gas = new int[] {1,2,3,4,5};
        int[] cost = new int[] {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currentGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++){
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];
            if (currentGas < 0){
                start = i+1;
                currentGas = 0;
            }
        }
        return totalGas < 0 ? -1 : start;
    }
}
