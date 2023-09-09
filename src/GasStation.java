public class GasStation {
    public static void main(String[] args) {
        int[] gas = {5, 1, 2, 3, 4}, cost = {4, 4, 1, 5, 1};
        //int[] gas = {3, 1, 1}, cost = {1, 2, 2};
        //int[] gas = {5, 8, 2, 8}, cost = {6, 5, 6, 6};
        //int[] gas = {1, 2, 3, 4, 5, 5, 70}, cost = {2, 3, 4, 3, 9, 6, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1 && gas[0] >= cost[0]) return 0;
        else if (gas.length == 1) return -1;

        int[] diffs = new int[gas.length];
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            diffs[i] = gas[i] - cost[i];
            sum += diffs[i];
        }
        if (sum < 0) return -1;

        int i = 0, j = diffs.length - 1, k = i, newSum = 0;
        while (k != j) {
            newSum = newSum + diffs[k];
            if (newSum < 0) {
                j = k;
                i = (k + 1) % diffs.length;
                newSum = 0;
            }
            k = (k + 1) % diffs.length;
        }
        return i;
    }
}
