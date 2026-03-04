package ru.melnikov.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            printMenu();
            System.out.print("Выбор: ");

            String choice = sc.nextLine().trim();

            System.out.println();

            switch (choice) {
                case "1":
                    Demos.demoStudent(sc);
                    break;

                case "2":
                    Demos.demoDirectory(sc);
                    break;

                case "3":
                    Demos.demoPoint3D(sc);
                    break;

                case "4":
                    Demos.demoFigures(sc);
                    break;

                case "5":
                    Demos.demoEqualsAndClone(sc);
                    break;

                case "6":
                    Demos.demoPower(args, sc);
                    break;

                case "0":
                    System.out.println("Выход");
                    sc.close();
                    return;

                default:
                    System.out.println("Неверный пункт меню. Повтори.");
            }

            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("===== ЛР 3 (вариант 9) =====");
        System.out.println("1) Student (оценки 2..5)");
        System.out.println("2) Телефонный справочник");
        System.out.println("3) Трёхмерная точка");
        System.out.println("4) Фигуры и площадь + общая площадь");
        System.out.println("5) equals + clone (Point)");
        System.out.println("6) Возведение X^Y");
        System.out.println("0) Выход");
    }
}