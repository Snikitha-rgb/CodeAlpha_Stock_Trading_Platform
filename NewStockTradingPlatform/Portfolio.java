 
class Portfolio {
    String[] ownedStocks;
    int[] ownedShares;
    double cashBalance;
    
    public Portfolio() {
        ownedStocks = new String[3];
        ownedShares = new int[3];
        cashBalance = 10000.0; // Initial cash balance
    }
    
    public void buyStock(String stockName, int shares, MarketData market) {
        double price = market.getPrice(stockName);
        if (price < 0) {
            System.out.println("Stock not found.");
            return;
        }
        
        double cost = price * shares;
        if (cashBalance >= cost) {
            cashBalance -= cost;
            for (int i = 0; i < ownedStocks.length; i++) {
                if (ownedStocks[i] == null) {
                    ownedStocks[i] = stockName;
                    ownedShares[i] = shares;
                    break;
                } else if (ownedStocks[i].equals(stockName)) {
                    ownedShares[i] += shares;
                    break;
                }
            }
            System.out.println("Bought " + shares + " shares of " + stockName);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    
    public void sellStock(String stockName, int shares, MarketData market) {
        for (int i = 0; i < ownedStocks.length; i++) {
            if (ownedStocks[i] != null && ownedStocks[i].equals(stockName)) {
                if (ownedShares[i] >= shares) {
                    double price = market.getPrice(stockName);
                    ownedShares[i] -= shares;
                    cashBalance += price * shares;
                    System.out.println("Sold " + shares + " shares of " + stockName);
                    if (ownedShares[i] == 0) {
                        ownedStocks[i] = null;
                    }
                } else {
                    System.out.println("Not enough shares to sell.");
                }
                return;
            }
        }
        System.out.println("Stock not found in portfolio.");
    }
    
    public void displayPortfolio() {
        System.out.println("Current Portfolio:");
        for (int i = 0; i < ownedStocks.length; i++) {
            if (ownedStocks[i] != null) {
                System.out.println(ownedStocks[i] + ": " + ownedShares[i] + " shares");
            }
        }
        System.out.println("Cash Balance: $" + cashBalance);
    }
}
