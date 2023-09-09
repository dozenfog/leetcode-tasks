public class Stock {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit1(prices));
    }
    //7,1,5,3,6,4
    //2, 1, 2, 0, 1
    //5,2,3,2,6,6,2,9,1,0,7,4,5,0

    public static int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int i = 0, j = 1, sum = Integer.MIN_VALUE;
        while (i < prices.length - 1) {
            if (prices[j] - prices[i] > sum) sum = prices[j] - prices[i];
            if (prices[j] - prices[i] <= 0 && j != prices.length - 1) {
                i = j;
            }
            j++;
            if (j == prices.length && i < prices.length - 1) {
                i++;
                j = i + 1;
            }
        }
        return Math.max(0, sum);
    }

    public static int maxProfit1(int[] prices) {
        if (prices.length == 1) return 0;
        int i = 0, j = 1, sum = Integer.MIN_VALUE, ans = 0;
        while (j <= prices.length) {
            if (j == prices.length) {
                ans += sum;
                break;
            }
            if (prices[j] - prices[i] <= 0) {
                if (sum > 0) {
                    ans += sum;
                    sum = 0;
                }
                i = j;
                j++;
            } else if (prices[j] - prices[i] > 0 && prices[j] - prices[i] > sum) {
                sum = prices[j] - prices[i];
                j++;
            } else if (prices[j] - prices[i] > 0 && prices[j] - prices[i] <= sum) {
                ans += sum;
                i = j;
                j++;
                sum = 0;
            }
        }
        return Math.max(0, ans);
    }
}
