package ru.melnikov.main;

import ru.melnikov.geometry.Figure;

public class FigureUtils {

    private FigureUtils() {
    }

    /**
     * Задание 5.3
     * Возвращает суммарную площадь переданных фигур.
     */
    public static double totalArea(Figure... figures) {

        if (figures == null) return 0;

        double sum = 0;

        for (Figure f : figures) {
            if (f != null) {
                sum += f.getArea();
            }
        }

        return sum;
    }
}