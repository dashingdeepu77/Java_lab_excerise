import java.util.ArrayList;
import java.util.List;

// Generic class for representing a Car
class Car<T> {
    private T carDetails;

    public Car(T carDetails) {
        this.carDetails = carDetails;
    }

    public T getCarDetails() {
        return carDetails;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carDetails=" + carDetails +
                '}';
    }
}

// Generic interface for Sales operations
interface SalesOperation<T> {
    void sellItem(T item);
}

// Concrete implementation of SalesOperation for selling cars
class CarSalesOperation implements SalesOperation<Car<String>> {
    @Override
    public void sellItem(Car<String> car) {
        // Implement the logic for selling a car
        System.out.println("Sold Car: " + car.getCarDetails());
    }
}

// Generic method for processing sales
class SalesProcessor {
    public static <T> void processSale(T item, SalesOperation<T> salesOperation) {
        // Perform any pre-sale operations

        // Sell the item using the provided SalesOperation
        salesOperation.sellItem(item);

        // Perform any post-sale operations
    }
}

// Generic class for representing a Customer
class Customer<T> {
    private T customerDetails;

    public Customer(T customerDetails) {
        this.customerDetails = customerDetails;
    }

    public T getCustomerDetails() {
        return customerDetails;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerDetails=" + customerDetails +
                '}';
    }
}

// Concrete implementation of SalesOperation for selling customers
class CustomerSalesOperation implements SalesOperation<Customer<String>> {
    @Override
    public void sellItem(Customer<String> customer) {
        // Implement the logic for selling a customer
        System.out.println("Sold Customer: " + customer.getCustomerDetails());
    }
}

// Example usage
public class CarSalesDemo {
    public static void main(String[] args) {
        // Creating a generic car instance
        Car<String> sedanCar = new Car<>("Sedan Car - Model ABC");

        // Selling the car using the SalesProcessor
        SalesProcessor.processSale(sedanCar, new CarSalesOperation());

        // Creating a generic customer instance
        Customer<String> customer = new Customer<>("John Doe");

        // Selling the customer using the SalesProcessor
        SalesProcessor.processSale(customer, new CustomerSalesOperation());
    }
}
