package com.pluralsight;

import java.util.ArrayList;

 public class Dealership {
    private String name;
    private String address;
    private String phone;
    private final ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public Vehicle searchByVin(int vin) {
        return null;
    }

    public ArrayList<Vehicle> searchByPrice(double minPrice, double maxPrice) {
        return null;
    }

    public ArrayList<Vehicle> searchByMakeAndModel(String make, String model) {
        return null;
    }

    public void removeVehicle(int vin) {
        // To be implemented later
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}


