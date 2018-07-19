/*
 * class: PlayroomFilter
 *
 * version: 1.0 18 Jul 2018
 *
 * author: Maxim Burishinets
 */

package by.epam.training.service;

import by.epam.training.model.Playroom;
import by.epam.training.model.toy.*;
import by.epam.training.model.toy.comparsion.ColorComparator;
import by.epam.training.model.toy.comparsion.PriceComparator;
import by.epam.training.model.toy.comparsion.SizeComparator;
import by.epam.training.model.toy.comparsion.TypeComparator;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Class PlayroomFilter provides methods to find and sort toys
 * that contains object of Playroom class, also allowing to see
 * list of all toys in the room
 */

public abstract class PlayroomFilter {

    private static final Logger logger = Logger.getLogger(PlayroomFilter.class);

    private static List<String> validParams;

    // method find all toys, that satisfied list of parameters
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

    /*
     * method sorts collection of toys in the given playroom using
     * corresponding comparator
     */
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

    // prints list of toys in the room
    public static void showToys(List<Toy> toys) {
        for (Toy toy : toys) {
            logger.info(toy);
        }
    }

    private static void wrongParamMessage() {
        logger.info("wrong parameter");
    }

    private static void wrongParamMessage(String param) {
        logger.info("wrong parameter: " + param);
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
