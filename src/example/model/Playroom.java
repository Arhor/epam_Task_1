/*
 *
 *
 *
 *
 *
 *
 */

package example.model;

import java.util.ArrayList;
import java.util.List;

import example.model.toy.*;

public class Playroom {

    private List<Toy> toys = new ArrayList<>();

    private double currency;

    private double totalPrice;

    /*
     * Конструктор в качестве параметра принимает кол-во выделенных средств
     * и наполняет комнату случайными игрушками до тех пор, пока выделенная
     * сумма не закончится
     */
    public Playroom(double currency) {
        this.currency = currency;
        while (true) {
            Toy toy = new Toy();
            if (this.currency >= toy.getPrice()) {
                this.addToy(toy);
            } else {
                break;
            }
        }
    }

    public Playroom() {
        this(500);
    }

    /*
     * Метод добавляет игрушку в игровую комнату, вычитает её стоимость
     * из выделенных средств, и добавляет её к общей стоимости игрушек
     */
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
