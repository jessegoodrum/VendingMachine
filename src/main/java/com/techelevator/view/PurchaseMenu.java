package com.techelevator.view;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class PurchaseMenu extends Menu {
    private static final String Purchase_MAIN_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MAIN_MENU_OPTIONS_FINISH_TRANSACTION = "Finish Transaction";
    public static final String[] PURCHASE_MAIN_MENU_OPTIONS = { Purchase_MAIN_MENU_OPTION_FEED_MONEY, PURCHASE_MAIN_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MAIN_MENU_OPTIONS_FINISH_TRANSACTION };

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

    public PurchaseMenu(InputStream input, OutputStream output) {
        super(input, output);
    }                                                                               // after change in access modifier in Menu, override the methods if needed

    @Override
    public Object getChoiceFromOptions(Object[] options) {
        return super.getChoiceFromOptions(options);
    }

    @Override
    public Object getChoiceFromUserInput(Object[] options) {
        return super.getChoiceFromUserInput(options);
    }

    @Override
    public void displayMenuOptions(Object[] options) {
        super.displayMenuOptions(PURCHASE_MAIN_MENU_OPTIONS);
    }

    public int PurchaseMenu(){

        System.out.println("1) Feed Money");
        System.out.println("2) Select Product");
        System.out.println("3) Finish Transaction");
        System.out.println();
        System.out.println("Current Money : " + balance); // was balance
        System.out.println();
        int intSelection = 0;
        System.out.println("Please select 1,2,or 3:");
        Scanner input = new Scanner(System.in);
        String selection = input.nextLine();
        try {   intSelection = Integer.parseInt(selection);}
        catch (NumberFormatException e){
            System.out.println("Please enter 1, 2, or 3 ");
        }

        return intSelection;
    }

    public void secondOption(){
        inventory.displayInventory();
        System.out.println();
        System.out.println("Enter a location: ");
        System.out.println("Balance: $" + balance);
        String location = input.nextLine().toUpperCase();
        for (Snack menu : inventory.getInventory()){
            if(location.contentEquals(menu.getLocation())){
                location = menu.getLocation();
                if(menu.getQuantity() == 0){
                    System.out.println("Sold Out");
                    System.out.println();
                    break;
                }else if (balance >= menu.getPrice()){
                    balance -= menu.getPrice();
                    System.out.println("Here's your " + menu.getName());
                    System.out.println(menu.sounds());
                    System.out.println();
                    System.out.println("Balance Remaining $" + balance);
                    System.out.println(); //Feed money
                    menu.setQuantity(menu.getQuantity()-1);
                    log.log(menu.getName() + " " + menu.getLocation() + " $"+ menu.getPrice() + " $" + balance);
                    System.out.println();
                    break;

                }else if(balance <= menu.getPrice()){
                    System.out.println("You don't have enough money for " + menu.getName());
                    System.out.println();
                    break;
                }
            }
            else {
                System.out.println("Cannot find that location");
                System.out.println();
                break;
            }


        }
    }



}

