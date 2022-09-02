package com.techelevator.view;

public class Chip extends Snack {
    @Override
    public String sounds() {
        return "Crunch Crunch, Yum!";
    }

    public Chip(String name, String location, double price, int quantity) {
        super(name, location, price, quantity);
    }
}
