package ru.melnikov.geometry;

import java.util.Objects;

public class Point implements Cloneable {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // ===== 6.2 equals + hashCode =====

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // ===== 8.4 clone =====

    @Override
    public Point clone() {
        return new Point(this.x, this.y);
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}