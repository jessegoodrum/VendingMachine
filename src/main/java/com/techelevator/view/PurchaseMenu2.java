package com.techelevator.view;
import java.io.PrintWriter;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class PurchaseMenu2 {

    private static final String Purchase_MAIN_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MAIN_MENU_OPTIONS_FINISH_TRANSACTION = "Finish Transaction";
    public static final String[] PURCHASE_MAIN_MENU_OPTIONS = {Purchase_MAIN_MENU_OPTION_FEED_MONEY, PURCHASE_MAIN_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MAIN_MENU_OPTIONS_FINISH_TRANSACTION};
    private FeedMoney feed = new FeedMoney();
    private double balance = feed.totalMoney;

    private Scanner input = new Scanner(System.in);
    private Inventory inventory = new Inventory(new File("C:\\Users\\Keithhaye57\\OneDrive\\Desktop\\Week1\\Capstone 615\\capstone-1\\vendingmachine.csv"));
    private Logger log = new Logger();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int PurchaseMenu2() {

        System.out.println("1) Feed Money");
        System.out.println("2) Select Product");
        System.out.println("3) Finish Transaction");
        System.out.println();
        System.out.println("Current Money : " + getBalance()); // was balance
        System.out.println();
        int intSelection = 0;
        System.out.println("Please select 1,2,or 3:");
        Scanner input = new Scanner(System.in);
        String selection = input.nextLine();
        try {
            intSelection = Integer.parseInt(selection);
        } catch (NumberFormatException e) {
            System.out.println("Please enter 1, 2, or 3 ");
        }

        return intSelection;
    }

    public String secondOption(String location, double balance) {
        for (Snack menu : inventory.getInventory()) {
            if (location.contentEquals(menu.getLocation())) {
                location = menu.getLocation();
                if (menu.getQuantity() == 0) {
                   return "Sold Out";
                } else if (balance >= menu.getPrice()) {
                    balance -= menu.getPrice();
                    menu.setQuantity(menu.getQuantity() - 1);
                    log.log(menu.getName() + " " + menu.getLocation() + " $" + menu.getPrice() + " $" + balance);
                    return "Here's your " + menu.getName()+ "\n" + menu.sounds() + "\n" +"Balance Remaining $" + balance + "\n";
                } else if (balance <= menu.getPrice()) {
                    return "You don't have enough money for " + menu.getName() + "\n";
                }
            } else {
                return "Cannot find that location" + "\n";
            }
        }
        return "Invalid Entry";
    }

}
