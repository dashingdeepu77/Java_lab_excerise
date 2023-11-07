class Car {
    private String make;
    private String model;
    private int year;
    private double price;

    
    public Car() {
        make = "Unknown";
        model = "Unknown";
        year = 0;
        price = 0.0;
    }

   
    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

   
    public void displayCarInfo() {
        System.out.println(year + " " + make + " " + model + ", Price: Rs" + price);
    }

   
    public double calculateTotalPrice() {
        return price;
    }

    public double calculateTotalPrice(double taxRate) {
        return price + (price * taxRate);
    }

    public double calculateTotalPrice(double taxRate, double discount) {
        double totalPrice = price + (price * taxRate);
        return totalPrice - (totalPrice * discount);
    }

  
    public void updateCarInfo(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }
}

class CarSales {
    private Car[] inventory;

   
    public CarSales() {
        inventory = new Car[0];
    }

  
    public CarSales(Car[] initialInventory) {
        inventory = initialInventory;
    }

    public void addCar(Car car) {
        Car[] newInventory = new Car[inventory.length + 1];
        System.arraycopy(inventory, 0, newInventory, 0, inventory.length);
        newInventory[inventory.length] = car;
        inventory = newInventory;
    }

    public void listAllCars() {
        for (Car car : inventory) {
            car.displayCarInfo();
        }
    }
}

public class CarSalesSystem {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2023, 2500000);
        Car car2 = new Car("Honda", "Civic", 2023, 2200000);
        Car car3 = new Car("Ford", "F-150", 2023, 3500000);

        CarSales carSales = new CarSales();
        carSales.addCar(car1);
        carSales.addCar(car2);
        carSales.addCar(car3);

        System.out.println("Cars in inventory:");
        carSales.listAllCars();

        car1.updateCarInfo("Toyota", "Camry XLE", 2023, 2700000);
        System.out.println("Updated car information:");
        car1.displayCarInfo();
        System.out.println("Total price with tax: Rs" + car1.calculateTotalPrice(0.1));
        System.out.println("Total price without tax: Rs" + car1.calculateTotalPrice());
    }
}
