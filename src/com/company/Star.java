package com.company;

public class Star {

    private double x;
    private double y;
    private double innerRadius;
    private double outerRadius;
    private int numRays;

    public Star(double x, double y, double innerRadius, double outerRadius, int numRays) {     // конструктор для звезды
        this.x = x;
        this.y = y;
        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
        this.numRays = numRays;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double innerRadius() {
        return innerRadius;
    }

    public double outerRadius() {
        return outerRadius;
    }

    public int numRays() {
        return numRays;
    }
}
