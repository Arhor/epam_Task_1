package example.playroom;

import java.util.ArrayList;
import java.util.Comparator;
import example.playroom.toy.Toy;

public class Playroom {
    ArrayList<Toy> toys = new ArrayList<>();
    private double currency;
    private double totalPrice;

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

    private void addToy(Toy toy) {
        toys.add(toy);
        this.currency -= toy.getPrice();
        this.totalPrice += toy.getPrice();
    }

    public double getCurrency() {
        return this.currency;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void getToys() {
        for (Toy t : toys) {
            System.out.println(t.toString());
        }
    }

    public void sortBy(String arg) {
        Comparator<Toy> comp = null;
        switch(arg.toUpperCase()) {
            case "SIZE":
                comp = new Toy.SizeComparator();
                break;
            case "TYPE":
                comp = new Toy.TypeComparator();
                break;
            case "COLOR":
                comp = new Toy.ColorComparator();
                break;
            case "PRICE":
                comp = new Toy.PriceComparator();
                break;
            default:
                System.out.println("Введён неверный параметр");
        }
        if (comp != null) {
            toys.sort(comp);
            this.getToys();
        }
    }

    public static void help() {
        System.out.println("Список доступных команд:\n" +
                "\t1 - просмотреть список игрушек в комнате\n" +
                "\t2 - отсортировать игрушки в комнате\n" +
                "\t3 - поиск игрушек по параметрам\n" +
                "\t4 - просмотреть общей стоимости игрушек\n" +
                "\t5 - просмотреть остаток денежных средств\n" +
                "\th - просмотреть список команд\n" +
                "\tq - выход");
    }
}
