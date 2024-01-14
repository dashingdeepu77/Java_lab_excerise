import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarSalesApp extends JFrame {

    private JComboBox<String> carModels;
    private JTextField quantityField;
    private JButton calculateButton;

    // Sample car models and their prices
    private String[] models = {"Sedan", "SUV", "Truck"};
    private double[] prices = {25000.0, 35000.0, 45000.0};

    public CarSalesApp() {
        // Set up the JFrame
        setTitle("Car Sales Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        carModels = new JComboBox<>(models);
        quantityField = new JTextField(10);
        calculateButton = new JButton("Calculate Total Price");

        // Set layout manager
        setLayout(new GridLayout(3, 2));

        // Add components to the JFrame
        add(new JLabel("Select Car Model:"));
        add(carModels);
        add(new JLabel("Enter Quantity:"));
        add(quantityField);
        add(new JLabel("Total Price:"));
        add(calculateButton);

        // Add action listener to the Calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotalPrice();
            }
        });
    }

    private void calculateTotalPrice() {
        try {
            // Get the selected car model and quantity
            String selectedModel = (String) carModels.getSelectedItem();
            int quantity = Integer.parseInt(quantityField.getText());

            // Find the index of the selected model
            int index = -1;
            for (int i = 0; i < models.length; i++) {
                if (models[i].equals(selectedModel)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                // Calculate the total price
                double totalPrice = prices[index] * quantity;

                // Display the total price in a JOptionPane
                JOptionPane.showMessageDialog(this, "Total Price for " + quantity + " " +
                        selectedModel + "(s): $" + totalPrice, "Total Price", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid car model", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid quantity", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CarSalesApp().setVisible(true);
            }
        });
    }
}
