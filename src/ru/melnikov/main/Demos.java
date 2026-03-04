package ru.melnikov.main;

import ru.melnikov.students.Student;

import java.util.Arrays;
import java.util.Scanner;

public class Demos {

    private Demos() {
    }
    // СТУДЕНТ 1.9
    public static void demoStudent(Scanner sc) {
        System.out.println("Demo Student");
        System.out.println("Здесь будет демонстрироваться выполнение задания 1.9 (Диапазон оценок)");
        System.out.println();

        // 1) Создаём студента с корректными оценками
        Student vasya = new Student("Вася", 3, 4, 5);
        System.out.println("Создали студента: " + vasya);
        System.out.println("Средний балл: " + vasya.getAverageGrade());
        System.out.println("Отличник? " + vasya.isExcellentStudent());
        System.out.println();

        // 2) Показываем, что нельзя изменить оценки извне
        int[] arr = vasya.getGrades();
        arr[0] = 100; // пытаемся сломать
        System.out.println("Пробуем изменить массив, который вернул getGrades(): " + Arrays.toString(arr));
        System.out.println("Студент после попытки изменения извне: " + vasya);
        System.out.println();

        // 3) Демонстрируем, что некорректную оценку задать нельзя
        System.out.println("Пробуем добавить некорректную оценку 6:");
        try {
            vasya.addGrade(6);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймали ошибку: " + e.getMessage());
        }
        System.out.println();

        // 4) Демонстрируем, что в конструкторе тоже нельзя
        System.out.println("Пробуем создать студента с оценкой 1:");
        try {
            Student bad = new Student("Петя", 5, 1, 4);
            System.out.println(bad); // сюда не дойдёт
        } catch (IllegalArgumentException e) {
            System.out.println("Поймали ошибку: " + e.getMessage());
        }
        System.out.println();
        System.out.println("Demo Student завершён.");
    }

    // PHONEDIRECTORY 2.3
    public static void demoDirectory(Scanner sc) {
        System.out.println("Demo PhoneDirectory");
        System.out.println("Здесь будет показано выполнение задания 2.3 (Желтые страницы)");
        System.out.println();

        ru.melnikov.directory.PhoneDirectory dir = new ru.melnikov.directory.PhoneDirectory();

        System.out.println("Добавляем пары:");
        System.out.println("Старый телефон (Вася): " + dir.add("89003337788", "Вася"));
        System.out.println("Старый телефон (Маша): " + dir.add("89111111111", "Маша"));
        System.out.println("Старый телефон (Петя): " + dir.add("89222222222", "Петя"));
        System.out.println("Справочник: " + dir);
        System.out.println();

        System.out.println("Меняем телефон Васи (должен вернуться старый):");
        String old = dir.add("89999999999", "Вася");
        System.out.println("Старый телефон Васи: " + old);
        System.out.println("Справочник: " + dir);
        System.out.println();

        System.out.println("Получаем телефон по имени:");
        System.out.println("Телефон Пети: " + dir.getPhoneByName("Петя"));
        System.out.println("Телефон Кати (нет в справочнике): " + dir.getPhoneByName("Катя"));
        System.out.println();

        System.out.println("Проверки contains:");
        System.out.println("Есть имя 'Маша'? " + dir.containsName("Маша"));
        System.out.println("Есть телефон 89111111111? " + dir.containsPhone("89111111111"));
        System.out.println("Есть телефон 000? " + dir.containsPhone("000"));
        System.out.println();

        System.out.println("Удаляем Машу:");
        dir.removeByName("Маша");
        System.out.println("Справочник: " + dir);
        System.out.println("Количество контактов: " + dir.size());
        System.out.println();

        System.out.println("Массивы:");
        System.out.println("Все пары: " + java.util.Arrays.toString(dir.getAllPairs()));
        System.out.println("Все телефоны: " + java.util.Arrays.toString(dir.getAllPhones()));
        System.out.println("Все имена: " + java.util.Arrays.toString(dir.getAllNames()));
        System.out.println();

        System.out.println("Имена по префиксу:");
        System.out.println("Префикс 'В': " + java.util.Arrays.toString(dir.getNamesByPrefix("В")));
        System.out.println("Префикс 'Пе': " + java.util.Arrays.toString(dir.getNamesByPrefix("Пе")));
        System.out.println();
        System.out.println("Demo PhoneDirectory завершён.");
    }
    // 3.5 Point + Point3D
    public static void demoPoint3D(Scanner sc) {
        System.out.println("Demo Point3D");
        System.out.println("Здесь будет показано выполнение задания 3.5 (Трехмерная точка)");
        System.out.println();
        ru.melnikov.geometry.Point p2 = new ru.melnikov.geometry.Point(3, 5);
        System.out.println("2D точка: " + p2);
        ru.melnikov.geometry.Point3D p3 = new ru.melnikov.geometry.Point3D(3, 5, 7);
        System.out.println("3D точка: " + p3);
        System.out.println("Меняем Z координату...");
        p3.setZ(10);
        System.out.println("3D точка после изменения: " + p3);
        System.out.println("Demo Point3D завершён.");
    }

    // 4.4 Фигуры + площадь
    public static void demoFigures(Scanner sc) {
        System.out.println("Demo Figures");
        System.out.println("Здесь будет показано выполнение задания 4.4 и 5.3");
        System.out.println();

        ru.melnikov.geometry.Figure[] figures =
                new ru.melnikov.geometry.Figure[]{
                        new ru.melnikov.geometry.Circle(
                                new ru.melnikov.geometry.Point(0, 0), 5),

                        new ru.melnikov.geometry.Square(
                                new ru.melnikov.geometry.Point(0, 10), 4),

                        new ru.melnikov.geometry.Rectangle(
                                new ru.melnikov.geometry.Point(-2, 8), 3, 6),

                        new ru.melnikov.geometry.Triangle(
                                new ru.melnikov.geometry.Point(0, 0),
                                new ru.melnikov.geometry.Point(4, 0),
                                new ru.melnikov.geometry.Point(0, 3)
                        )
                };

        for (ru.melnikov.geometry.Figure f : figures) {
            System.out.println(f);
            System.out.println("Площадь = " + f.getArea());
            System.out.println();
        }

        System.out.println("Суммарная площадь всех фигур = " +
                ru.melnikov.main.FigureUtils.totalArea(figures));

        System.out.println();
        System.out.println("Demo завершён.");
    }

    public static void demoEqualsAndClone(Scanner sc) {
        System.out.println("Demo Point equals/clone");
        System.out.println("Здесь показано выполнение заданий 6.2 и 8.4");
        System.out.println();

        ru.melnikov.geometry.Point p1 =
                new ru.melnikov.geometry.Point(3, 5);

        ru.melnikov.geometry.Point p2 =
                new ru.melnikov.geometry.Point(3, 5);

        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);

        System.out.println("p1.equals(p2)? " + p1.equals(p2));
        System.out.println("p1 == p2? " + (p1 == p2));
        System.out.println();

        System.out.println("Клонируем p1...");
        ru.melnikov.geometry.Point p3 = p1.clone();

        System.out.println("p3 = " + p3);
        System.out.println("p1.equals(p3)? " + p1.equals(p3));
        System.out.println("p1 == p3? " + (p1 == p3));
        System.out.println();

        System.out.println("Меняем p3...");
        p3.setX(100);

        System.out.println("p1 после изменения p3: " + p1);
        System.out.println("p3 после изменения: " + p3);

        System.out.println();
        System.out.println("Demo завершён.");
    }

    //7.3
    public static void demoPower(String[] args, Scanner sc) {
        System.out.println("Demo Power X^Y");
        System.out.println("Задание 7.3 (Возведение в степень)");
        System.out.println();

        System.out.println(PowerUtils.powerFromArgsOrInput(args, sc));

        System.out.println();
    }
}