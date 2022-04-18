package com.epam.lab.api.service.figureTask.figure;

public class Cylinder extends FigureWithRadius {

    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        if (height <= 0) {
            throw new IllegalArgumentException("negative height");
        }
        this.height = height;
    }

    @Override
    public void calculationArea() {
        area = 2 * Math.PI * radius * (radius + height);
    }

    @Override
    public String toString() {
        return "Cylinder{" +
            "height=" + height +
            ", radius=" + radius +
            ", area=" + area +
            '}';
    }
}
