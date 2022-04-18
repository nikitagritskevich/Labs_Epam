package com.epam.lab.api.service.figureTask.adapter;

import com.epam.lab.api.service.figureTask.figure.Cylinder;
import com.epam.lab.api.service.figureTask.figure.Sphere;

public class CylinderAreaAdapter {

    private Sphere sphere;

    public CylinderAreaAdapter(Sphere sphere) {
        this.sphere = sphere;
    }

    public Cylinder getRequireFigure(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("negative radius");
        }
        double requireArea = sphere.getArea();
        double requireHeight = (requireArea / (2 * Math.PI* radius)) - radius;
        Cylinder resultCylinder = new Cylinder(radius, requireHeight);
        resultCylinder.calculationArea();
        return resultCylinder;
    }
}
