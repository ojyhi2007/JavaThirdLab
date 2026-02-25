import java.util.Arrays;

public class Student {

    private String name;
    private int[] grades;

    public Student(String name, int... grades) {
        this.name = name;
        setGrades(grades);
    }

    private void setGrades(int... grades) {
        if (grades == null) {
            this.grades = new int[0];
            return;
        }

        for (int grade : grades) {
            if (grade < 2 || grade > 5) {
                throw new IllegalArgumentException(
                        "Оценка должна быть в диапазоне от 2 до 5. Некорректная оценка: " + grade
                );
            }
        }

        this.grades = Arrays.copyOf(grades, grades.length);
    }

    public int[] getGrades() {
        // Возвращаем копию, чтобы нельзя было изменить оригинал
        return Arrays.copyOf(grades, grades.length);
    }

    public double getAverageGrade() {
        if (grades.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.length;
    }

    public boolean isExcellentStudent() {
        if (grades.length == 0) {
            return false;
        }

        for (int grade : grades) {
            if (grade != 5) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }
}
