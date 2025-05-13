package 贪心;

/**
 * 121. 买卖股票的最佳时机
 */
class Solution0121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy =  prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                max = Math.max(prices[i] - buy, max);
            }
        }
        return max;
    }
}