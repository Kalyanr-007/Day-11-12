package com.bridgelabz.day11and12;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class StockManagment {
        private String name;
        private int numberOfShares;
        private double sharePrice;

        public StockManagment(String name, int numberOfShares, double sharePrice) {
            this.name = name;
            this.numberOfShares = numberOfShares;
            this.sharePrice = sharePrice;
        }

        public String getName() {
            return name;
        }

        public int getNumberOfShares() {
            return numberOfShares;
        }

        public double getSharePrice() {
            return sharePrice;
        }

        public double calculateStockValue() {
            return numberOfShares * sharePrice;
        }
    }

    class StockPortfolio {
        private List<StockManagment> stocks;

        public StockPortfolio() {
            stocks = new ArrayList<>();
        }

        public void addStock(StockManagment stock) {
            stocks.add(stock);
        }

        public double calculateTotalStockValue() {
            double totalValue = 0;
            for (StockManagment stock : stocks) {
                totalValue += stock.calculateStockValue();
            }
            return totalValue;
        }

        public void printStockReport() {
            System.out.println("Stock Report:");
            System.out.println("--------------------");
            for (StockManagment stock : stocks) {
                double stockValue = stock.calculateStockValue();
                System.out.println("Stock Name: " + stock.getName());
                System.out.println("Number of Shares: " + stock.getNumberOfShares());
                System.out.println("Share Price: $" + stock.getSharePrice());
                System.out.println("Stock Value: $" + stockValue);
                System.out.println("--------------------");
            }
            double totalStockValue = calculateTotalStockValue();
            System.out.println("Total Stock Value: $" + totalStockValue);
        }
    }

    class StockManagement {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            StockPortfolio stockPortfolio = new StockPortfolio();

            System.out.print("Enter the number of stocks: ");
            int numStocks = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= numStocks; i++) {
                System.out.println("Enter details for Stock " + i + ":");
                System.out.print("Stock Name: ");
                String name = scanner.nextLine();
                System.out.print("Number of Shares: ");
                int numberOfShares = scanner.nextInt();
                System.out.print("Share Price: ");
                double sharePrice = scanner.nextDouble();
                scanner.nextLine();

                StockManagment stock = new StockManagment(name, numberOfShares, sharePrice);
                stockPortfolio.addStock(stock);
            }

            stockPortfolio.printStockReport();
            scanner.close();
        }
    }


