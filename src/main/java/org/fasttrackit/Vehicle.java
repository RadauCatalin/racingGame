package org.fasttrackit;

public class Vehicle {
    String name;
    double mileage;
    double maxSpeed;
    String fuelType;
    double fuelLevel;
    double travelDistance;
    boolean running;

    public double accelerate(double speed, double durationInHours) {
        System.out.println(name + "is aceelerating with" + speed + "km/h for" + " h.");
        double distance = speed * durationInHours;
        System.out.println("Distance: " + distance);

        travelDistance = travelDistance + distance;
        //same result as the above statement
//        travelDistance += distance;

        return distance;
    }
}