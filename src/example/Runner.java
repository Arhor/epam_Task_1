package example;

import example.model.Playroom;
import example.service.PlayroomFilter;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Playroom pr;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter money sum, that will be used to" +
                " fill the playroom: ");
        try {
            pr = new Playroom(Double.parseDouble(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format, playroom will be " +
                    "filled automatically");
            pr = new Playroom();
        }
        pr.buyToys();
        if (pr.isEmpty()) {
            System.out.println("There is not enough money to buy toys");
            return;
        }
        System.out.println("Toys in the playroom: " + pr.getToysAmount());
        help();
        while (!pr.isEmpty()) {
            System.out.print("> ");
            switch (scanner.nextLine()) {
                case "1":
                    PlayroomFilter.showToys(pr.getToys());
                    break;
                case "2":
                    System.out.println("parameters to sort toys by: " +
                            "size, type, color, price");
                    System.out.print("> ");
                    PlayroomFilter.sortBy(pr.getToys(), scanner.nextLine());
                    break;
                case "3":
                    System.out.println("parameters to find toys by:\n" +
                            "\tsize: small, medium, large\n" +
                            "\ttype: car, doll, cube, ball\n" +
                            "\tcolor: red, green, blue");
                    System.out.print("> ");
                    PlayroomFilter.findToys(pr, scanner.nextLine());
                    break;
                case "4":
                    System.out.println("Total cost of toys in playroom: "
                            + pr.getTotalPrice());
                    break;
                case "5":
                    System.out.println("Cash balance: "
                            + pr.getCurrency());
                    break;
                case "h":
                    help();
                    break;
                case "q":
                    return;
                default:
                    System.out.println("invalid command...");
            }
        }
    }

    private static void help() {
        System.out.println("Type one of the following commands and press ENTER:\n" +
                "\t1 - list of toys in the playroom\n" +
                "\t2 - sort toys\n" +
                "\t3 - find toys\n" +
                "\t4 - get total cost of the toys\n" +
                "\t5 - get cash balance\n" +
                "\th - help\n" +
                "\tq - exit");
    }
}
