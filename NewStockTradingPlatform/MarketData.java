 
class MarketData {
    String[] stockNames;
    double[] stockPrices;
    
    public MarketData() {
        stockNames = new String[]{"APPLE", "GOOGLE", "MICROSOFT"};
        stockPrices = new double[]{150.0, 2800.0, 300.0};
    }
    
    public void displayMarketData() {
        System.out.println("Current Market Prices:");
        for (int i = 0; i < stockNames.length; i++) {
            System.out.println(stockNames[i] + ": $" + stockPrices[i]);
        }
    }
    
    public double getPrice(String stockName) {
        for (int i = 0; i < stockNames.length; i++) {
            if (stockNames[i].equals(stockName)) {
                return stockPrices[i];
            }
        }
        return -1; // Stock not found
    }
}
