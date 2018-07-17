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

    private static List<String> validParams;

    public static void findToys(Playroom playroom, String params) {
        ArrayList<Toy> filtered = new ArrayList<>(playroom.getToys());
        String[] filters = params.toUpperCase().split(" ");
        for (String filter : filters) {
            if (!validParams.contains(filter)) {
                wrongParamMessage();
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

    public static void sortBy(List<Toy> toys, String param) {
        Comparator<Toy> comp = null;
        switch(param.toUpperCase()) {
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
                wrongParamMessage(param);
        }
        if (comp != null) {
            toys.sort(comp);
            showToys(toys);
        }
    }

    private static void wrongParamMessage() {
        System.out.println("wrong parameter");
    }

    private static void wrongParamMessage(String param) {
        System.out.println("wrong parameter: " + param);
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
