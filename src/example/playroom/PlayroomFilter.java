package example.playroom;

import example.playroom.toy.Toy;
import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class PlayroomFilter {

    private static ArrayList<String> validParams;

    public static void findToys(Playroom playroom, String params) {
        ArrayList<Toy> filtered = new ArrayList<>(playroom.toys);
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
        for (Toy toy : filtered) {
            System.out.println(toy.toString());
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
