package com.epam.lab.api.service;

import com.epam.lab.api.service.figureTask.adapter.CylinderAreaAdapter;
import com.epam.lab.api.service.figureTask.figure.Cylinder;
import com.epam.lab.api.service.figureTask.figure.Sphere;
import java.util.Scanner;

public class TaskWithArea {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter radius sphere: = ");
            double radiusSphere = in.nextDouble();
            Sphere sphere = new Sphere(radiusSphere);
            sphere.calculationArea();
            System.out.println(sphere);
            CylinderAreaAdapter adapter = new CylinderAreaAdapter(sphere);
            for (int i = 1; i <= 5; i++) {
                Cylinder cylinder = adapter.getRequireFigure(i);
                cylinder.calculationArea();
                System.out.println(cylinder);
            }
        }
    }
}
