package ru.melnikov.geometry;

public class Circle implements Figure {

    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        if (center == null) throw new IllegalArgumentException("center is null");
        if (radius <= 0) throw new IllegalArgumentException("radius must be > 0");
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        if (center == null) throw new IllegalArgumentException("center is null");
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("radius must be > 0");
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{center=" + center + ", radius=" + radius + "}";
    }
}