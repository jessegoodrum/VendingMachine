package com.techelevator.view;

public class Candy extends Snack{
    @Override
    public String sounds() {
        return "Munch Munch, Yum!";
    }

    public Candy(String name, String location, double price, int quantity) {
        super(name, location, price, quantity);
    }

}
