package com.pluralsight;

public class SalesContract extends Contract {
    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.00;
    private static final double PROCESSING_FEE_UNDER_10000 = 295.00;
    private static final double PROCESSING_FEE_OVER_10000 = 495.00;
    private boolean isFinanced;
    private double price;

    public SalesContract(String date, String customerName, String customerEmail, String vehicleVIN, double price, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleVIN);
        this.price = price;
        this.isFinanced = isFinanced;
    }

    @Override
    public double getTotalPrice() {
        double processingFee = price < 10000 ? PROCESSING_FEE_UNDER_10000 : PROCESSING_FEE_OVER_10000;
        double salesTax = price * SALES_TAX_RATE;
        return price + salesTax + RECORDING_FEE + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) return 0.0;
        double interestRate = price >= 10000 ? 0.0425 : 0.0525;
        int term = price >= 10000 ? 48 : 24;
        double monthlyInterestRate = interestRate / 12;
        double totalPrice = getTotalPrice();
        return (totalPrice * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -term));
    }
}