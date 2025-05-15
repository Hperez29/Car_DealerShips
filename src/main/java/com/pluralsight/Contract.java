package com.pluralsight;

public abstract class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private String vehicleVIN;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String date, String customerName, String customerEmail, String vehicleVIN) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleVIN = vehicleVIN;
    }

    public String getDate() { return date; }
    public String getCustomerName() { return customerName; }
    public String getCustomerEmail() { return customerEmail; }
    public String getVehicleVIN() { return vehicleVIN; }

    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();
}