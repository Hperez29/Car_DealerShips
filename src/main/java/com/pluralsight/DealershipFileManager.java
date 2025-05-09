package com.pluralsight;

import java.io.*;

public class DealershipFileManager {

    private static final String FILE_NAME = "inventory.csv";

    // Method to read the dealership file and load it into a Dealership object
    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            if (line != null) {
                // First line contains dealership info
                String[] dealershipInfo = line.split("\\|");
                String name = dealershipInfo[0];
                String address = dealershipInfo[1];
                String phone = dealershipInfo[2];

                // Create a Dealership object
                dealership = new Dealership(name, address, phone);

                // Read the remaining lines for vehicle information
                while ((line = reader.readLine()) != null) {
                    String[] vehicleInfo = line.split("\\|");

                    // Parse the vehicle details
                    int vin = Integer.parseInt(vehicleInfo[0]);
                    int year = Integer.parseInt(vehicleInfo[1]);
                    String make = vehicleInfo[2];
                    String model = vehicleInfo[3];
                    String type = vehicleInfo[4];
                    String color = vehicleInfo[5];
                    int mileage = Integer.parseInt(vehicleInfo[6]);
                    double price = Double.parseDouble(vehicleInfo[7]);

                    // Create a new Vehicle object and add it to the dealership's inventory
                    Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
                    dealership.addVehicle(vehicle);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dealership;
    }

    // Method to save the dealership data back to the file
    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            // Write the dealership information
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            // Write the vehicle information
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" + vehicle.getType() + "|" + vehicle.getColor() + "|" +
                        vehicle.getMileage() + "|" + vehicle.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
