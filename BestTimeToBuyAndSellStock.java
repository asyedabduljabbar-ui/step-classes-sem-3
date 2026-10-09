public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int lowestPrice = prices[0];
        int bestProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - lowestPrice;
            if (profit > bestProfit) {
                bestProfit = profit;
            }
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }
        }
        return bestProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
