package by.epam.training.runner;

import by.epam.training.model.Playroom;
import by.epam.training.service.PlayroomFilter;
import java.util.Scanner;
import org.apache.log4j.*;

public class Runner {

    // LOGGER for the class
    private static final Logger LOGGER = Logger.getLogger(Runner.class);

    public static void main(String[] args) {
        Playroom pr;
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter money sum, that will be used to" +
                " fill the playroom: ");
        try {
            pr = new Playroom(Double.parseDouble(scanner.nextLine()));
        } catch (NumberFormatException e) {
            LOGGER.info("Wrong number format, playroom will be " +
                    "filled automatically");
            pr = new Playroom();
        }
        pr.buyToys();
        if (pr.isEmpty()) {
            LOGGER.info("There is not enough money to buy toys");
            return;
        }
        LOGGER.info("Toys in the playroom: " + pr.getToysAmount());
        help();
        while (!pr.isEmpty()) {
            switch (scanner.nextLine()) {
                case "1":
                    PlayroomFilter.showToys(pr.getToys());
                    break;
                case "2":
                    LOGGER.info("parameters to sort toys by: " +
                            "size, type, color, price");
                    PlayroomFilter.sortBy(pr.getToys(), scanner.nextLine());
                    break;
                case "3":
                    LOGGER.info("parameters to find toys by:\n" +
                            "\tsize: small, medium, large\n" +
                            "\ttype: car, doll, cube, ball\n" +
                            "\tcolor: red, green, blue");
                    PlayroomFilter.findToys(pr, scanner.nextLine());
                    break;
                case "4":
                    LOGGER.info("Total cost of toys in playroom: "
                            + pr.getTotalPrice());
                    break;
                case "5":
                    LOGGER.info("Cash balance: " + pr.getCurrency());
                    break;
                case "h":
                    help();
                    break;
                case "q":
                    return;
                default:
                    LOGGER.info("invalid command...");
            }
        }
    }

    private static void help() {
        LOGGER.info("Type one of the following commands and press ENTER:\n" +
                "\t1 - list of toys in the playroom\n" +
                "\t2 - sort toys\n" +
                "\t3 - find toys\n" +
                "\t4 - get total cost of the toys\n" +
                "\t5 - get cash balance\n" +
                "\th - help\n" +
                "\tq - exit");
    }
}
