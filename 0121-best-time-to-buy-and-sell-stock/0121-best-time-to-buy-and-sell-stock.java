class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update the lowest buy price seen so far
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // Update maximum profit if current profit is higher
            }
        }

        return maxProfit;
    }
}