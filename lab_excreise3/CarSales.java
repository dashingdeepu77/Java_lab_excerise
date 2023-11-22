
class Vehicle {
    private String brand;
    private String model;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Vehicle: " + brand + " " + model);
    }
}

abstract class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int numberOfDoors) {
        super(brand, model);
        this.numberOfDoors = numberOfDoors;
    }

    public abstract void start();

    public void displayCarInfo() {
        super.displayInfo();
        System.out.println("Number of doors: " + numberOfDoors);
    }
}

final class Sedan extends Car {
    public Sedan(String brand, String model, int numberOfDoors) {
        super(brand, model, numberOfDoors);
    }

    @Override
    public void start() {
        System.out.println("Starting Sedan...");
    }
}

final class SUV extends Car {
    public SUV(String brand, String model, int numberOfDoors) {
        super(brand, model, numberOfDoors);
    }

    @Override
    public void start() {
        System.out.println("Starting SUV...");
    }
}

public class CarSales {
    public static void main(String[] args) {
        Sedan sedan = new Sedan("Toyota", "Camry", 4);
        SUV suv = new SUV("Ford", "Explorer", 5);

        sedan.displayCarInfo();
        sedan.start();
        System.out.println();

        suv.displayCarInfo();
        suv.start();
    }
}
