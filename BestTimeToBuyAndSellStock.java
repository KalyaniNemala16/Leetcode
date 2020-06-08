class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices == null) return 0;
        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i<prices.length ; i++){
            if(min > prices[i])
                min = prices[i];
            else if(max < prices[i] - min)
                max = prices[i] - min;
        }
        return max;
    }
}
