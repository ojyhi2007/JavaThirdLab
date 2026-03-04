package ru.melnikov.geometry;

public class Square implements Figure {

    private Point topLeft;
    private double side;

    public Square(Point topLeft, double side) {
        if (topLeft == null) throw new IllegalArgumentException("topLeft is null");
        setSide(side);
        this.topLeft = topLeft;
    }

    public Square(double x, double y, double side) {
        this(new Point(x, y), side);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        if (topLeft == null) throw new IllegalArgumentException("topLeft is null");
        this.topLeft = topLeft;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Длина стороны квадрата должна быть больше 0");
        }
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Square{topLeft=" + topLeft + ", side=" + side + "}";
    }
}