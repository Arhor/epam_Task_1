/*
 *
 *
 *
 *
 *
 *
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

    /* конструктор случайным образом определяет параметры текущей игрушки */
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

    /* цена имеет вид (type * size + color) */
    private void setPrice() {
        this.price = prices.get(this.type.toString())
                * prices.get(this.size.toString())
                + prices.get(this.color.toString());
    }

    public double getPrice() {
        return this.price;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@"
                + "size: " + getSize()
                + ", type: " + getType()
                + ", color: " + getColor()
                + ", price: " + getPrice();
    }

    /*
     * статический блок логики
     * при создании первой игрушки производится попытка получить доступ
     * к файлу "prices.txt", содержащему список цен для заполения
     * хэш-карты, на основании которой впоследствии определяются цены
     * для каждой созданной игрушки
     */
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
