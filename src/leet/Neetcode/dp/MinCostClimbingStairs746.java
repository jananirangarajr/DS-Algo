package leet.Neetcode.dp;

import java.util.Arrays;

public class MinCostClimbingStairs746 {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }
    static int minCostStairs[];
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
//        minCostStairs = new int[n];
//        Arrays.fill(minCostStairs,-1);
//        minCostStairs[n-1] = cost[n-1];
//        minCostStairs[n-2] = cost[n-2];
//        minCostStairs[1] = minCost(cost,1);
//        minCostStairs[0] = minCost(cost,0);
//        return Math.min(minCostStairs[0],minCostStairs[1]);
        int costOne = cost[n-1];
        int costTwo = 0;

        for (int i = n-2; i >=0 ; i--){
            cost[i] = Math.min((cost[i]+costOne), (cost[i]+costTwo));
            costTwo = costOne;
            costOne= cost[i];
        }
        return Math.min(cost[0],cost[1]);
    }

    private static int minCost(int[] cost, int index){
        if (minCostStairs[index] != -1)
            return minCostStairs[index];
        if (index == cost.length-1)
            return cost[index];
        if (index >= cost.length)
            return 0;
        int curCost = cost[index]+Math.min(minCost(cost,index+1),minCost(cost,index+2));
        minCostStairs[index] = curCost;
        return curCost;

    }

}
