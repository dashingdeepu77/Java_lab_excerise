import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Car {
    private String make;
    private String model;
    private double price;

    public Car(String make, String model, double price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}

class CarSalesperson implements Runnable {
    private String name;
    private List<Car> carsForSale;

    public CarSalesperson(String name, List<Car> carsForSale) {
        this.name = name;
        this.carsForSale = carsForSale;
    }

    @Override
    public void run() {
        while (!carsForSale.isEmpty()) {
            sellCar();
        }
        System.out.println(name + " has sold all cars.");
    }

    private void sellCar() {
        synchronized (carsForSale) {
            if (!carsForSale.isEmpty()) {
                Random random = new Random();
                int index = random.nextInt(carsForSale.size());
                Car car = carsForSale.remove(index);
                System.out.println(name + " sold " + car.getMake() + " " + car.getModel() + " for $" + car.getPrice());
            }
        }

        try {
            Thread.sleep(100); // Simulate some time taken to complete the sale
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CarSalesDemo {
    public static void main(String[] args) {
        List<Car> carsForSale = new ArrayList<>();
        carsForSale.add(new Car("Toyota", "Camry", 25000.0));
        carsForSale.add(new Car("Honda", "Accord", 27000.0));
        carsForSale.add(new Car("Ford", "Mustang", 35000.0));
        carsForSale.add(new Car("Chevrolet", "Malibu", 28000.0));
        carsForSale.add(new Car("Nissan", "Altima", 26000.0));

        CarSalesperson salesperson1 = new CarSalesperson("John", carsForSale);
        CarSalesperson salesperson2 = new CarSalesperson("Alice", carsForSale);

        Thread thread1 = new Thread(salesperson1);
        Thread thread2 = new Thread(salesperson2);

        thread1.start();
        thread2.start();
    }
}
