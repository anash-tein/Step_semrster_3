public class BestTimeToBuyAndSellStock {
    
    static int maxProfit(int[] prices) {
        int minPriceSoFar = prices[0];
        int maxProfit = 0;
 
        for (int i = 1; i < prices.length; i++) {
            int profitToday = prices[i] - minPriceSoFar;
            maxProfit = Math.max(maxProfit, profitToday);
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
        }
        return maxProfit;
    }
 
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}) + "  (expected 5)");
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}) + "  (expected 0)");
    }
}
