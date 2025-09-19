package Arrays;

public class GasStation {

	public static void main(String[] args) {
		int gas[] = {1,2,4,5,9}, cost[] = {3,4,1,10,1};
		System.out.println("start point to complete circular trip is + "+canCompleteCircuit(gas, cost));

	}
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        //if the tot gas is less than cost
        int start = 0, currGas = 0, totGas = 0, totCost = 0;

        for(int i=0;i<gas.length;i++){
            totGas += gas[i];
            totCost += cost[i];
            currGas += gas[i] - cost[i];

            if(currGas < 0){
                start = i+1;
                currGas = 0;
            }
        }
        return totGas < totCost ? -1 : start;
    }
}
