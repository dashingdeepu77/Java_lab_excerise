import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum FuelType {
    PETROL, DIESEL, ELECTRIC
}

class Car {
    private String model;
    private double price;
    private FuelType fuelType;

    public Car(String model, double price, FuelType fuelType) {
        this.model = model;
        this.price = price;
        this.fuelType = fuelType;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return "Model: " + model + ", Price: " + price + ", Fuel Type: " + fuelType;
    }
}

@FunctionalInterface
interface CarFilter {
    boolean filter(Car car);
}

public class CarSales {
    public static void main(String[] args) {
        // Creating a list of cars
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Sedan1", 35000, FuelType.PETROL));
        cars.add(new Car("SUV1", 45000, FuelType.DIESEL));
        cars.add(new Car("Electric1", 60000, FuelType.ELECTRIC));
        cars.add(new Car("Sedan2", 32000, FuelType.PETROL));

        // Sorting cars by price using lambda expression
        cars.sort((car1, car2) -> Double.compare(car1.getPrice(), car2.getPrice()));

        System.out.println("Cars sorted by price:");
        cars.forEach(System.out::println);

        System.out.println("\nElectric Cars:");
        // Filtering electric cars using lambda expression and a custom functional interface
        List<Car> electricCars = filterCars(cars, car -> car.getFuelType() == FuelType.ELECTRIC);
        electricCars.forEach(System.out::println);
    }

    // Method to filter cars based on a custom criteria using a functional interface
    private static List<Car> filterCars(List<Car> cars, CarFilter carFilter) {
        return cars.stream()
                .filter(carFilter::filter)
                .collect(Collectors.toList());
    }
}
