package org.fasttrackit;

public class App {
    public static void main(String[] args) {

        Engine engine = new Engine();
        engine.manufacturer = "Renault";
        engine.capacity = 1600;

        Car car = new Car(engine);
        car.setName("Dacia");
        car.setFuelLevel(60);
        car.setMileage(8.5);
        car.doorCount = 5;
        car.setMaxSpeed(180);
        car.setFuelType("Gasoline");

        System.out.println("Car object: " + car.toString());

        System.out.println(car.getName());
        System.out.println(car.getTraveledDistance());
        System.out.println(car.isRunning());

        System.out.println(car.engine);

        car.accelerate(61, 1);
        Engine engine2 = new Engine();
        engine2.manufacturer = "VW";
        engine2.capacity = 1900;

        Car car2 = new Car(engine2);
        car2.setName("Golf");
        car2.setFuelLevel(75);
        car2.setMileage(9.3);
        car2.doorCount = 3;
        car2.setMaxSpeed(240);
        car2.setFuelType("Gasoline");

        car2.setName("Skoda");
//car.name = null;
//concatenation=concatenare
        System.out.println("Car2 name: " + car2.getName());
        System.out.println("Car1 name: " + car.getName());
//car = car2;

//System.out.println("Static variables example:");
//we should only call static variables from the class itself (Car),
//not from a variable containing an object of the class
//car.totalCount = 1;
//
//System.out.println("Total count in car: " + car.totalCount);
//
//car2.totalCount = 2;
//
//System.out.println("Total count in car after setting car2: " + car.totalCount);
//System.out.println("Total count in car 2: " + car2.totalCount);
//System.out.println("Total count in car class " + Car.totalCount);
    HybridCar HybridCar = new HybridCar();
    HybridCar.setName("Tesla");
    HybridCar.setFuelLevel(60);
    HybridCar.accelerate(60, 1);

        System.out.println(HybridCar.getFuelLevel());
        System.out.println(HybridCar.getTraveledDistance());

    }
}