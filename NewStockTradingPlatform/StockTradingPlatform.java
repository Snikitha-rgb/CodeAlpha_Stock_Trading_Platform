
import java.util.Scanner;

public class StockTradingPlatform {
    public static void main(String[] args) {
        MarketData market = new MarketData();
        Portfolio portfolio = new Portfolio();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Display Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. Display Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            if (choice == 5) {
                break;
            }
            
            switch (choice) {
                case 1:
                    market.displayMarketData();
                    break;
                case 2:
                    System.out.print("Enter stock name: ");
                    String buyStockName = scanner.next();
                    System.out.print("Enter number of shares: ");
                    int buyShares = scanner.nextInt();
                    portfolio.buyStock(buyStockName, buyShares, market);
                    break;
                case 3:
                    System.out.print("Enter stock name: ");
                    String sellStockName = scanner.next();
                    System.out.print("Enter number of shares: ");
                    int sellShares = scanner.nextInt();
                    portfolio.sellStock(sellStockName, sellShares, market);
                    break;
                case 4:
                    portfolio.displayPortfolio();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        
        scanner.close();
    }
}
