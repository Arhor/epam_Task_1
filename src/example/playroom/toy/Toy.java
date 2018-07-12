package example.playroom.toy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Toy {
    private static HashMap<String, Double> prices;
    private double price;

    private Size size;
    private Type type;
    private Color color;

    public Toy() {
        int s = (int)(Math.random() * 3 + 1);
        int t = (int)(Math.random() * 4 + 1);
        int c = (int)(Math.random() * 3 + 1);
        switch (t) {
            case 1:
                this.type = Type.CAR;
                break;
            case 2:
                this.type = Type.DOLL;
                break;
            case 3:
                this.type = Type.CUBE;
                break;
            case 4:
                this.type = Type.BALL;
        }
        switch (s) {
            case 1:
                this.size = Size.SMALL;
                break;
            case 2:
                this.size = Size.MEDIUM;
                break;
            case 3:
                this.size = Size.LARGE;
        }
        switch (c) {
            case 1:
                this.color = Color.RED;
                break;
            case 2:
                this.color = Color.GREEN;
                break;
            case 3:
                this.color = Color.BLUE;
        }
        this.setPrice();
    }

    private void setPrice() {
        this.price = prices.get(this.type.toString()) * prices.get(this.size.toString())
                + prices.get(this.color.toString());
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("%6s %5s %4s - its price is %.1f", this.size, this.color, this.type, this.getPrice());
    }

    public Size getSize() {
        return this.size;
    }

    public Type getType() {
        return this.type;
    }

    public Color getColor() {
        return this.color;
    }

    private enum Size {
        SMALL, MEDIUM, LARGE
    }
    private enum Type {
        CAR, DOLL, CUBE, BALL
    }
    private enum Color {
        RED, GREEN, BLUE
    }

    public static class SizeComparator implements Comparator<Toy> {
        @Override
        public int compare(Toy one, Toy two) {
            return one.getSize().compareTo(two.getSize());
        }
    }

    public static class TypeComparator implements Comparator<Toy> {
        @Override
        public int compare(Toy one, Toy two) {
            return one.getType().compareTo(two.getType());
        }
    }

    public static class ColorComparator implements Comparator<Toy> {
        @Override
        public int compare(Toy one, Toy two) {
            return one.getColor().compareTo(two.getColor());
        }
    }

    public static class PriceComparator implements Comparator<Toy> {
        @Override
        public int compare(Toy one, Toy two) {
            return (int)(one.getPrice() - two.getPrice());
        }
    }

    static {
        prices = new HashMap<>();
        File file = new File("prices.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String temp = scanner.nextLine();
                if(temp.matches("\\w+=[0-9]+(\\.[0-9])?")) {
                    String str = temp.replaceAll("[^a-zA-Z]", "");
                    Double num = Double.valueOf(temp.replaceAll("\\w+=",""));
                    prices.put(str, num);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e); // файл не обнаружен!!! TODO: реализовать цены по-умолчанию
        }
    }
}
