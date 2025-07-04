package besttimetobuyandsellstock;

/**
 * Problem: #121 Best Time to Buy and Sell Stock
 *
 * Description:
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 * Solution's time complexity and space complexity:
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class BestTimeToBuyAndSellStock {

    public int maximumProfit(int[] prices) {
        // Initialize to the highest possible value to make sure the prices array's first iteration is always lesser
        int minimumPrice = Integer.MAX_VALUE;
        int maximumProfit = 0; // Initialize profit to 0

        for (int price : prices) {
            if (price < minimumPrice) {
                minimumPrice = price; // Update the minimum price found so far
            } else if (price - minimumPrice > maximumProfit) {
                maximumProfit = price - minimumPrice; // Update max profit if selling today gives better profit
            }
        }
        return maximumProfit;
    }
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        BestTimeToBuyAndSellStock main = new BestTimeToBuyAndSellStock();
        System.out.println(main.maximumProfit(prices));
    }
}