package problem_134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int costOfRoute = 0;
        for (int i = 0; i < n; ++i) {
            costOfRoute = costOfRoute + gas[i] - cost[i];
        }

        if (costOfRoute < 0) return -1;
        // If there exists a solution, it is guaranteed to be unique
        int answer = 0;
        int remainsGas = 0;
        for (int i = 0; i < n; ++i) {
            remainsGas = remainsGas + gas[i] - cost[i]; // how many gas after move
            if (remainsGas < 0) {
                answer = i + 1;
                remainsGas = 0;
            }
        }
        return answer;
    }
}