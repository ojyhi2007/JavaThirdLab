package ru.melnikov.main;

import ru.melnikov.utils.InputUtils;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class PowerUtils {

    private PowerUtils() {
    }

    /**
     * Задание 7.3:
     * Возведение X в степень Y.
     * X и Y передаются как строки (args),
     * либо вводятся с клавиатуры.
     */
    public static String powerFromArgsOrInput(String[] args, Scanner sc) {

        int x;
        int y;

        // Если передали аргументы командной строки
        if (args != null && args.length >= 2) {
            try {
                x = parseInt(args[0]);
                y = parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Аргументы некорректны. Введите значения вручную.");
                x = InputUtils.readInt(sc, "Введите X (целое число): ");
                y = InputUtils.readInt(sc, "Введите Y (целое число): ");
            }
        } else {
            x = InputUtils.readInt(sc, "Введите X (целое число): ");
            y = InputUtils.readInt(sc, "Введите Y (целое число): ");
        }

        double result = pow(x, y);

        return x + "^" + y + " = " + result;
    }
}