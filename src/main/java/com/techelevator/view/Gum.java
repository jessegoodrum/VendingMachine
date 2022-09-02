package com.techelevator.view;

public class Gum extends Snack{
    @Override
    public String sounds() {
        return "Chew Chew, Yum!";
    }

    public Gum(String name, String location, double price, int quantity) {
        super(name, location, price, quantity);
    }
}
