import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class VehicleIdentificationSystem {
    // JDBC variables
    static final String DB_URL = "jdbc:postgresql://localhost:5432/vehicle_db"; 
    static final String USER = "postgres";
    static final String PASS = "1234";
    Connection conn;

    public VehicleIdentificationSystem() {
        // Create main frame
        JFrame mainFrame = new JFrame("Vehicle Identification System");
        mainFrame.setSize(450, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.getContentPane().setBackground(new Color(240, 240, 240)); // Light gray background

        JLabel label = new JLabel("Select an option:");
        label.setBounds(150, 10, 150, 20); // Centered label
        label.setFont(new Font("Arial", Font.BOLD, 16)); // Stylish font
        mainFrame.add(label);

        // Registration Button
        JButton regButton = new JButton("Vehicle Registration");
        regButton.setBounds(125, 60, 200, 40); // Centered and increased height for spacing
        regButton.setBackground(new Color(100, 149, 237)); // Cornflower blue
        regButton.setForeground(Color.WHITE);
        regButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Stylish font
        regButton.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Border
        mainFrame.add(regButton);

        // Identification Button
        JButton idButton = new JButton("Vehicle Identification");
        idButton.setBounds(125, 120, 200, 40); // Centered and increased height for spacing
        idButton.setBackground(new Color(100, 149, 237)); // Cornflower blue
        idButton.setForeground(Color.WHITE);
        idButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Stylish font
        idButton.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Border
        mainFrame.add(idButton);

        // Event handling for buttons
        regButton.addActionListener(e -> openRegistrationFrame());
        idButton.addActionListener(e -> openIdentificationFrame());

        mainFrame.setVisible(true);
    }

    private void openRegistrationFrame() {
        JFrame registerFrame = new JFrame("Vehicle Registration");
        registerFrame.setSize(450, 500);
        registerFrame.setLayout(null);
        registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registerFrame.getContentPane().setBackground(new Color(240, 240, 240)); // Light gray background

        // Form fields
        JLabel vehicleIdLabel = new JLabel("Vehicle ID:");
        vehicleIdLabel.setBounds(20, 20, 150, 25);
        JTextField vehicleIdField = new JTextField();
        vehicleIdField.setBounds(180, 20, 150, 25);

        JLabel regNumberLabel = new JLabel("Registration Number:");
        regNumberLabel.setBounds(20, 60, 150, 25);
        JTextField regNumberField = new JTextField();
        regNumberField.setBounds(180, 60, 150, 25);

        JLabel engineNumberLabel = new JLabel("Engine Number:");
        engineNumberLabel.setBounds(20, 100, 150, 25);
        JTextField engineNumberField = new JTextField();
        engineNumberField.setBounds(180, 100, 150, 25);

        JLabel chassisNumberLabel = new JLabel("Chassis Number:");
        chassisNumberLabel.setBounds(20, 140, 150, 25);
        JTextField chassisNumberField = new JTextField();
        chassisNumberField.setBounds(180, 140, 150, 25);

        JLabel ownerIdLabel = new JLabel("Owner ID:");
        ownerIdLabel.setBounds(20, 180, 150, 25);
        JTextField ownerIdField = new JTextField();
        ownerIdField.setBounds(180, 180, 150, 25);

        JLabel modelLabel = new JLabel("Model:");
        modelLabel.setBounds(20, 220, 150, 25);
        JTextField modelField = new JTextField();
        modelField.setBounds(180, 220, 150, 25);

        JLabel colorLabel = new JLabel("Color:");
        colorLabel.setBounds(20, 260, 150, 25);
        JTextField colorField = new JTextField();
        colorField.setBounds(180, 260, 150, 25);

        JButton registerBtn = new JButton("Register Vehicle");
        registerBtn.setBounds(120, 320, 150, 30);
        registerBtn.setBackground(new Color(50, 205, 50)); // Lime green
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setFont(new Font("Arial", Font.BOLD, 14)); // Stylish font
        registerBtn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2)); // Border

        // Adding components to the frame
        registerFrame.add(vehicleIdLabel);
        registerFrame.add(vehicleIdField);
        registerFrame.add(regNumberLabel);
        registerFrame.add(regNumberField);
        registerFrame.add(engineNumberLabel);
        registerFrame.add(engineNumberField);
        registerFrame.add(chassisNumberLabel);
        registerFrame.add(chassisNumberField);
        registerFrame.add(ownerIdLabel);
        registerFrame.add(ownerIdField);
        registerFrame.add(modelLabel);
        registerFrame.add(modelField);
        registerFrame.add(colorLabel);
        registerFrame.add(colorField);
        registerFrame.add(registerBtn);

        registerBtn.addActionListener(e -> {
            try {
                int vehicleId = Integer.parseInt(vehicleIdField.getText());
                String regNumber = regNumberField.getText();
                String engineNumber = engineNumberField.getText();
                String chassisNumber = chassisNumberField.getText();
                int ownerId = Integer.parseInt(ownerIdField.getText());
                String model = modelField.getText();
                String color = colorField.getText();
                registerVehicle(vehicleId, regNumber, engineNumber, chassisNumber, ownerId, model, color);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid integer values for Vehicle ID and Owner ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        registerFrame.setVisible(true);
    }
    
    private void registerVehicle(int vehicleId, String regNumber, String engineNumber, String chassisNumber, int ownerId, String model, String color) {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            }

            // Insert Vehicle details
            String insertVehicleSQL = "INSERT INTO Vehicle (vehicle_id, registration_number, engine_number, chassis_number, owner_id, model, color) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement vehicleStmt = conn.prepareStatement(insertVehicleSQL);
            vehicleStmt.setInt(1, vehicleId); // Setting vehicle_id as an integer
            vehicleStmt.setString(2, regNumber);
            vehicleStmt.setString(3, engineNumber);
            vehicleStmt.setString(4, chassisNumber);
            vehicleStmt.setInt(5, ownerId); // Setting owner_id as an integer
            vehicleStmt.setString(6, model);
            vehicleStmt.setString(7, color);
            vehicleStmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Vehicle registered successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error registering vehicle: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void openIdentificationFrame() {
        JFrame identifyFrame = new JFrame("Vehicle Identification");
        identifyFrame.setSize(450,500);
        identifyFrame.setLayout(null);
        identifyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel regLabel = new JLabel("Enter Registration Number:");
        regLabel.setBounds(20, 20, 200, 25);
        JTextField regField = new JTextField();
        regField.setBounds(180, 20, 150, 25);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(120, 60, 150, 30);
        searchBtn.setBackground(new Color(0, 153, 0)); // Set button background to green
        searchBtn.setForeground(Color.WHITE); // Set text color to white


        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(20, 100, 350, 200);
        outputArea.setEditable(false);

        searchBtn.addActionListener(e -> {
            String regNumber = regField.getText();
            searchVehicle(regNumber, outputArea);
        });

        identifyFrame.add(regLabel);
        identifyFrame.add(regField);
        identifyFrame.add(searchBtn);
        identifyFrame.add(outputArea);

        identifyFrame.setVisible(true);
    }

    private void searchVehicle(String regNumber, JTextArea outputArea) {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            }

            String query = "SELECT * FROM Vehicle JOIN Owner ON Vehicle.owner_id = Owner.owner_id WHERE registration_number = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, regNumber);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String result = "Vehicle Details:\n" +
                        "Registration Number: " + rs.getString("registration_number") + "\n" +
                        "Engine Number: " + rs.getString("engine_number") + "\n" +
                        "Chassis Number: " + rs.getString("chassis_number") + "\n" +
                        "Model: " + rs.getString("model") + "\n" +
                        "Color: " + rs.getString("color") + "\n\n" +
                        "Owner Details:\n" +
                        "Name: " + rs.getString("name") + "\n" +
                        "Address: " + rs.getString("address") + "\n" +
                        "Phone Number: " + rs.getString("phone_number");
                outputArea.setText(result);
            } else {
                outputArea.setText("No vehicle found with registration number: " + regNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VehicleIdentificationSystem::new);
    }
}

