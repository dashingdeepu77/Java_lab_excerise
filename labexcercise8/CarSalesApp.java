import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Car {
    private String brand;
    private String model;
    private int year;
    private double price;

    public Car(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}

public class CarSalesApp {
    public static void main(String[] args) {
        // Create a list to store cars
        List<Car> carList = new ArrayList<>();

        // Add some sample cars
        carList.add(new Car("Toyota", "Camry", 2022, 25000.0));
        carList.add(new Car("Honda", "Civic", 2021, 22000.0));
        carList.add(new Car("Ford", "Escape", 2023, 28000.0));

        // Display the list of cars
        System.out.println("List of Cars:");
        displayCars(carList);

        // Add a new car to the list
        Car newCar = new Car("Chevrolet", "Malibu", 2024, 27000.0);
        carList.add(newCar);

        // Display the updated list of cars
        System.out.println("\nUpdated List of Cars:");
        displayCars(carList);

        // Remove a car from the list
        carList.remove(1);

        // Display the final list of cars
        System.out.println("\nFinal List of Cars:");
        displayCars(carList);
    }

    // Helper method to display the list of cars
    private static void displayCars(List<Car> cars) {
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
