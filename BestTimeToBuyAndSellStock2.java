class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
      if(prices.length <= 1 || prices == null) return 0;
        int max = prices[0];
        int min = prices[0];
        int total = 0;

        for(int i = 1 ; i<prices.length ; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            else if(prices[i] > min){
                max = prices[i];
                if(i == prices.length - 1 || prices[i+1] < prices[i]){
                    total = total + (max-min);
                    min = max;
                }
            }
        }
        return total;
    }
}
