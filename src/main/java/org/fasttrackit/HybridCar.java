package org.fasttrackit;

public class HybridCar extends Vehicle {


    public double accelerate(double speed, double durationInHours) {

        System.out.println(getName() + " is aceelerating with " + speed + "km/h for" + " h.");
        speed = speed * 2;
        double distance = speed * durationInHours;
        System.out.println("Distance: " + distance);

        double usedFuel = distance * getMileage() / 100;
        System.out.println("Used fuel: " + usedFuel * 0);
        setFuelLevel(getFuelLevel() - usedFuel);
        System.out.println("Remaining fuel: " + getFuelLevel());

        return distance;
    }
// co-variant return type
    @Override
    protected HybridCar clone() throws CloneNotSupportedException {
        return new HybridCar();
    }
    public void  fly(){
        System.out.println("Yeey! Flying!");
    }
}



