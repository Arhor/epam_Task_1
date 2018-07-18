/*
 * class: Playroom
 *
 * version: 1.0 18 Jul 2018
 *
 * author: Maxim Burishinets
 */

package example.model;

import java.util.ArrayList;
import java.util.List;
import example.model.toy.*;

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

    public void buyToys() {
        while (true) {
            Toy toy = Toy.createToy();
            if (this.currency >= toy.getPrice()) {
                this.addToy(toy);
            } else {
                break;
            }
        }
    }

    private void addToy(Toy toy) {
        toys.add(toy);
        this.currency -= toy.getPrice();
        this.totalPrice += toy.getPrice();
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
