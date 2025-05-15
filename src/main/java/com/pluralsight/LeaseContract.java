package com.pluralsight;

public class LeaseContract extends Contract {
    private static final double LEASE_FEE_RATE = 0.07;
    private static final double INTEREST_RATE = 0.04;
    private double price;

    public LeaseContract(String date, String customerName, String customerEmail, String vehicleVIN, double price) {
        super(date, customerName, customerEmail, vehicleVIN);
        this.price = price;
    }

    @Override
    public double getTotalPrice() {
        double leaseFee = price * LEASE_FEE_RATE;
        return price * 0.5 + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double monthlyInterestRate = INTEREST_RATE / 12;
        int term = 36;
        double totalPrice = getTotalPrice();
        return (totalPrice * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -term));
    }
}
