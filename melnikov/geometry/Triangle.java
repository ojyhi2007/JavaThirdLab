package ru.melnikov.geometry;

public class Triangle implements Figure {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException("Points must not be null");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        if (a == null) throw new IllegalArgumentException("a is null");
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        if (b == null) throw new IllegalArgumentException("b is null");
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        if (c == null) throw new IllegalArgumentException("c is null");
        this.c = c;
    }

    @Override
    public double getArea() {
        double x1 = a.getX(), y1 = a.getY();
        double x2 = b.getX(), y2 = b.getY();
        double x3 = c.getX(), y3 = c.getY();

        double s = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return Math.abs(s) / 2.0;
    }

    @Override
    public String toString() {
        return "Triangle{a=" + a + ", b=" + b + ", c=" + c + "}";
    }
}