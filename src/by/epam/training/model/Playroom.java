/*
 * class: Playroom
 *
 * version: 1.0 18 Jul 2018
 *
 * author: Maxim Burishinets
 */

package by.epam.training.model;

import java.util.ArrayList;
import java.util.List;

import by.epam.training.model.toy.Toy;

public class Playroom {

    private List<Toy> toys = new ArrayList<>();

    private double currency;

    private double totalPrice;

    public Playroom(double currency) {
        this.currency = currency;
    }

    public Playroom() {
        this(500);
    }

    // adding toys to the playroom while there is enough cash
    public void buyToys() {
        while (true) {
            Toy toy = Toy.getInstance();
            if (this.currency >= toy.getPrice()) {
                toys.add(toy);
                this.currency -= toy.getPrice();
                this.totalPrice += toy.getPrice();
            } else {
                break;
            }
        }
    }

    public boolean isEmpty() {
        return this.toys.isEmpty();
    }

    public int getToysAmount() {
        return this.toys.size();
    }

    public double getCurrency() {
        return this.currency;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Toy> getToys() {
        return this.toys;
    }
}
