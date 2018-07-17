/*
 *
 *
 *
 *
 *
 *
 */

package example.service;

import example.model.Playroom;
import example.model.toy.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class PlayroomFilter {

    /* Список допустимых параметров поиска */
    private static List<String> validParams;

    /*
     * метод findToys в качестве параметров принимает объект класса Playroom
     * и строку с параметрами, по которым следует произвести поиск. Каждый
     * параметр выделяется в виде отдельной строки, которая проверяется на
     * соответствие списку допустимых параметров.
     */
    public static void findToys(Playroom playroom, String params) {
        ArrayList<Toy> filtered = new ArrayList<>(playroom.getToys());
        String[] filters = params.toUpperCase().split(" ");
        for (String filter : filters) {
            if (!validParams.contains(filter)) {
                System.out.println("Invalid parameter: " + filter);
                return;
            }
        }
        for (String filter : filters) {
            filtered = (ArrayList<Toy>) filtered.stream()
                    .filter(toy -> toy.toString().contains(filter))
                    .collect(Collectors.toList());
        }
        showToys(filtered);
    }

    public static void sortBy(List<Toy> toys, String arg) {
        Comparator<Toy> comp = null;
        switch(arg.toUpperCase()) {
            case "SIZE":
                comp = new SizeComparator();
                break;
            case "TYPE":
                comp = new TypeComparator();
                break;
            case "COLOR":
                comp = new ColorComparator();
                break;
            case "PRICE":
                comp = new PriceComparator();
                break;
            default:
                System.out.println("wrong parameter");
        }
        if (comp != null) {
            toys.sort(comp);
            showToys(toys);
        }
    }

    public static void showToys(List<Toy> toys) {
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }

    static {
        validParams = new ArrayList<>();
        validParams.add("SMALL");
        validParams.add("MEDIUM");
        validParams.add("LARGE");
        validParams.add("CAR");
        validParams.add("DOLL");
        validParams.add("CUBE");
        validParams.add("BALL");
        validParams.add("RED");
        validParams.add("GREEN");
        validParams.add("BLUE");
    }
}
