package com.bridgelabz.day11and12;

import java.util.Scanner;

public class Account {
        public double balance;

        public Account(double initialBalance) {

            if (initialBalance >= 0) {
                balance = initialBalance;
            } else {
                balance = 0.0;
            }
        }

        public void debit(double amount) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Debit successful. Remaining balance: " + balance);
            } else {
                System.out.println("Debit amount exceeded account balance.");
            }
        }

        public double getBalance() {
            return balance;
        }
    }


 class AccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial balance: ");
        double initialBalance = scanner.nextDouble();

        Account account = new Account(initialBalance);

        System.out.println("Initial balance: " + account.getBalance());

        System.out.print("Enter the debit amount: ");
        double debitAmount = scanner.nextDouble();

        account.debit(debitAmount);

        System.out.println("Balance after debit: " + account.getBalance());

        scanner.close();
    }
}



