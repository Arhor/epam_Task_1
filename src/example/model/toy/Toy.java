/*
 * class: Toy
 *
 * version: 1.0 18 Jul 2018
 *
 * author: Maxim Burishinets
 */

package example.model.toy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Toy {

    private static Map<String, Double> prices;

    private double price;

    private Size size;

    private Type type;

    private Color color;

    private void setPrice() {
        this.price = prices.get(this.type.toString())
                * prices.get(this.size.toString())
                + prices.get(this.color.toString());
    }

    Size getSize() {
        return this.size;
    }

    Type getType() {
        return this.type;
    }

    Color getColor() {
        return this.color;
    }

    public double getPrice() {
        return this.price;
    }

    public static Toy createToy() {
        Toy toy = new Toy();
        int s = (int)(Math.random() * 3 + 1);
        int t = (int)(Math.random() * 4 + 1);
        int c = (int)(Math.random() * 3 + 1);
        switch (t) {
            case 1:
                toy.type = Type.CAR;
                break;
            case 2:
                toy.type = Type.DOLL;
                break;
            case 3:
                toy.type = Type.CUBE;
                break;
            case 4:
                toy.type = Type.BALL;
        }
        switch (s) {
            case 1:
                toy.size = Size.SMALL;
                break;
            case 2:
                toy.size = Size.MEDIUM;
                break;
            case 3:
                toy.size = Size.LARGE;
        }
        switch (c) {
            case 1:
                toy.color = Color.RED;
                break;
            case 2:
                toy.color = Color.GREEN;
                break;
            case 3:
                toy.color = Color.BLUE;
        }
        toy.setPrice();
        return toy;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@"
                + "size: " + getSize()
                + ", type: " + getType()
                + ", color: " + getColor()
                + ", price: " + getPrice();
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
            e.printStackTrace();
        }
    }
}
