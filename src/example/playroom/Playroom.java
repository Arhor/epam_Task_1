package example.playroom;

import java.util.ArrayList;
import java.util.Comparator;
import example.playroom.toy.Toy;

public class Playroom {

    ArrayList<Toy> toys = new ArrayList<>();

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

    /*
     * Метод выводит в консоль список игрушек в комнате
     */
    public void getToys() {
        for (Toy t : toys) {
            System.out.println(t.toString());
        }
    }

    /*
     * Метод принимает в качестве параметра строку, и, если она является
     * допустимым параметром, прозводит сортировку коллекции с игрушками
     * используя соответствующий компаратор
     */
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
