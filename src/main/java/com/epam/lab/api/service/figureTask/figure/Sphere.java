package com.epam.lab.api.service.figureTask.figure;


public class Sphere extends FigureWithRadius {

    public Sphere(double radius) {
        super(radius);
    }

    @Override
    public void calculationArea() {
        area =  4 * Math.PI * Math.pow(radius, 2);
    }

}
