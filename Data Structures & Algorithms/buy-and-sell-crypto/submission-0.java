class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int result = 0;
        int size = prices.length;
        while(r < size){
            if(prices[l] < prices[r]){
                int temp = prices[r] - prices[l];
                result = Math.max(result, temp);
            } else {
                l = r;
            }
            r++;
        }
        return result;
    }
}
