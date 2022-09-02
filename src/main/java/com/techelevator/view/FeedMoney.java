package com.techelevator.view;

import java.util.Locale;
import java.util.Scanner;

public class FeedMoney {
    double totalMoney = 0;
    boolean YOrN = true;
    public double FeedMoney() {
        Scanner feedScan = new Scanner(System.in);
        double moneyConversion = 0 ;
        if (YOrN == true) {
            System.out.println("Enter the amount of money you fed the machine? ($1, $2, $5, $10 :");

            String money = feedScan.nextLine();

            try {
                moneyConversion = Double.parseDouble(money);
                if (moneyConversion != 10.0 && moneyConversion != 2.0 && moneyConversion != 5.0 && moneyConversion != 1.0)
                {
                    System.out.println(" Please enter a valid dollar amount");
                    FeedMoney();

                }


            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
                System.out.println("Would you like to try again? : ");
                String answer = feedScan.nextLine().toLowerCase(Locale.ROOT);
                if (answer.contentEquals("y")) {
                    FeedMoney();
                } else {
                    YOrN = false;
                }
            }
            if (  moneyConversion == 1.0 || moneyConversion == 5.0 || moneyConversion == 10.0 || moneyConversion == 2.0) {
                totalMoney += moneyConversion;
                System.out.println("The current balance is: " + totalMoney);
                System.out.println("Do you want to add more ? (Y/N)");
                String answer = feedScan.nextLine().toLowerCase(Locale.ROOT);

                if (answer.contentEquals("y")) {
                    YOrN = true;
                    FeedMoney();
                } else {
                    YOrN = false;
                }
            }
        }
        return totalMoney;
    }






    public boolean isYOrN() {
        return YOrN;
    }
}
