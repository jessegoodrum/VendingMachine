package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Inventory {
    final File INVENTORY_FILE;
    private List<Snack> snackList = new ArrayList<>(); // make a string list ?

    public Inventory(File Inventory){
        this.INVENTORY_FILE = Inventory;
        try{
            this.stockList();
        }catch (FileNotFoundException e){

        }
    }
    public void stockList() throws FileNotFoundException{
        try(Scanner scan = new Scanner(INVENTORY_FILE)){
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String [] splitUp = line.split("\\|");

                if(splitUp[3].contentEquals("Chip")){
                    Snack s = new Chip (splitUp[0], splitUp[1], Double.parseDouble(splitUp[2]),5);// make a snack LinkedList instead?

                    snackList.add(s); // * if snackList is a string list  then snackList.add(line)
                }
                if(splitUp[3].contentEquals("Candy")){
                    Snack s = new Candy (splitUp[0], splitUp[1], Double.parseDouble(splitUp[2]),5);
                    snackList.add(s);
                }
                if(splitUp[3].contentEquals("Drink")){
                    Snack s = new Drinks (splitUp[0], splitUp[1], Double.parseDouble(splitUp[2]),5);
                    snackList.add(s);
                }
                if(splitUp[3].contentEquals("Gum")){
                    Snack s = new Gum (splitUp[0], splitUp[1], Double.parseDouble(splitUp[2]),5);
                    snackList.add(s);
                }
            }
        }
    }



    public List<Snack> getInventory(){
        return snackList;
    }
    public void displayInventory(){

        for(Snack snack : snackList){

            System.out.print(snack.getLocation() + " ");
            System.out.print(snack.getName() + " ");
            System.out.print("$" + snack.getPrice() + " ");
            System.out.print( "Quantity : " + snack.getQuantity() + "\n");
        }
    }
}

