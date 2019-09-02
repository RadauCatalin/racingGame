package org.fasttrackit;

import java.util.Scanner;

public class Vehicle {
    String name;
    double mileage;
    double maxSpeed;
    String fuelType;
    double fuelLevel;
    double travelDistance;
    boolean running;

    public double accelerate(double speed, double durationInHours) {
        System.out.println(name + " is aceelerating with " + speed + "km/h for" + " h.");
        double distance = speed * durationInHours;
        System.out.println("Distance: " + distance);

        travelDistance = travelDistance + distance;
        //same result as the above statement
        //travelDistance += distance;

        double usedFuel = distance * mileage / 100;
        System.out.println("Used fuel: " + usedFuel);
        fuelLevel -= usedFuel;
        System.out.println("Remaining fuel: " + fuelLevel);

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println("Input from user:" + text);
        return distance;
    }
}