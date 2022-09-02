package com.techelevator;

import com.techelevator.view.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTIONS_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTIONS_EXIT};
	private double balance = 0; // future reference for FEED Money staring balance
	private Menu menu;
	private Inventory inventory = new Inventory(new File("vendingmachine.csv"));
	private Logger log = new Logger();
	FeedMoney feedMoney = new FeedMoney();

	private PurchaseMenu purchaseMenu = new PurchaseMenu(InputStream.nullInputStream(), OutputStream.nullOutputStream());
	private PurchaseMenu2 purchaseMenu2 = new PurchaseMenu2();

	private Scanner input = new Scanner(System.in);

	public Inventory getInventory() {
		return inventory;
	}

	public PurchaseMenu getPurchaseMenu() {
		return purchaseMenu;
	}

	public VendingMachineCLI(Menu menu) {                    // ,purchaseMenu purchaseMenu?
		this.menu = menu;

	}

	public void run() throws FileNotFoundException {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				inventory.displayInventory();//System.out.println(inventory.stockList());// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				do {
					int choice2 = purchaseMenu2.PurchaseMenu2();

					switch (choice2) {
						case 1:
							double money = feedMoney.FeedMoney();
							purchaseMenu2.setBalance(money);
							balance = purchaseMenu2.getBalance();
							log.log("Feed Money: " + " " + money + " $" + purchaseMenu2.getBalance() + " "  );
							break;
						case 2:
							inventory.displayInventory();
							System.out.println();
							System.out.println("Balance: $" + balance);
							System.out.println("Enter a location: ");
							String location = input.nextLine().toUpperCase();
							System.out.println(purchaseMenu2.secondOption(location, balance));

							choice = MAIN_MENU_OPTION_PURCHASE;
							break;
						case 3:
							System.out.println("Your change is $" + purchaseMenu.getBalance());
							log.log("Give Change : " + "$"+ balance + " " + "$0.00");
							choice = MAIN_MENU_OPTIONS_EXIT;
							break;

						default:
							System.out.println("Invalid menu choice; try again.");
							break;
					}
				} while(choice.equals(MAIN_MENU_OPTION_PURCHASE));{

				break;}



			}
			else if(choice.equals(MAIN_MENU_OPTIONS_EXIT)){
				System.out.println("Bye");
				break;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out); // probably need PurchaseMenu purchase Menu = new PurchaseMenu(in,out)
		VendingMachineCLI cli = new VendingMachineCLI(menu); // also ^^
		cli.run();
	}
}
