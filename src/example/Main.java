package example;

import example.playroom.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Playroom pr;
        Scanner scanner = new Scanner(System.in);
        Playroom.help();
        System.out.print("Введите размер денежной суммы: ");
        try {
            pr = new Playroom(Double.parseDouble(scanner.nextLine()));
            if (pr.isEmpty()) {
                System.out.println("Недостаточно средств для заполнения игровой комнаты");
            } else {
                System.out.println("Игрушек в комнате: " + pr.getToysAmount());
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат, игровая комната будет наполнена автоматически");
            pr = new Playroom();
        }
        while (!pr.isEmpty()) {
            System.out.print("> ");
            switch (scanner.nextLine()) {
                case "1":
                    pr.getToys();
                    break;
                case "2":
                    System.out.println("Введите параметр сортировки: size, type, color, price");
                    System.out.print("> ");
                    pr.sortBy(scanner.nextLine());
                    break;
                case "3":
                    System.out.println("Введите параметры поиска через пробел: size, type, color");
                    System.out.print("> ");
                    PlayroomFilter.findToys(pr, scanner.nextLine());
                    break;
                case "4":
                    System.out.println("Общая стоимость игрушек: " + pr.getTotalPrice());
                    break;
                case "5":
                    System.out.println("Остаток денежных средств: " + pr.getCurrency());
                    break;
                case "h":
                    Playroom.help();
                    break;
                case "q":
                    return;
                default:
                    System.out.println("неверная команда...");
            }
        }
    }
}
