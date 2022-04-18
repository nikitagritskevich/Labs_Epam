package com.epam.lab.api.service.figureTask.figure;

import lombok.Data;

@Data
public abstract class FigureWithRadius {

    protected double radius;
    protected double area;

    public FigureWithRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("negative radius");
        }
        this.radius = radius;
    }

    public abstract void calculationArea();
}
