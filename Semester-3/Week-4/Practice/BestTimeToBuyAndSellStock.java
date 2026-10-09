public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int bestProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profitToday = prices[i] - lowestPrice;

            if (profitToday > bestProfit) {
                bestProfit = profitToday;
            }

            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }
        }

        return bestProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
