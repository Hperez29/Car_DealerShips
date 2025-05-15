package com.pluralsight;


import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    private static final String CONTRACTS_FILE = "contracts.txt";

    public void saveContract(Contract contract) {
        try (FileWriter writer = new FileWriter(CONTRACTS_FILE, true)) {
            StringBuilder sb = new StringBuilder();

            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;
                sb.append("SALE|")
                        .append(salesContract.getDate()).append("|")
                        .append(salesContract.getCustomerName()).append("|")
                        .append(salesContract.getCustomerEmail()).append("|")
                        .append(salesContract.getVehicleVIN()).append("|")
                        .append(salesContract.getTotalPrice()).append("|")
                        .append(salesContract.getMonthlyPayment()).append("\n");
            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;
                sb.append("LEASE|")
                        .append(leaseContract.getDate()).append("|")
                        .append(leaseContract.getCustomerName()).append("|")
                        .append(leaseContract.getCustomerEmail()).append("|")
                        .append(leaseContract.getVehicleVIN()).append("|")
                        .append(leaseContract.getTotalPrice()).append("|")
                        .append(leaseContract.getMonthlyPayment()).append("\n");
            }

            writer.write(sb.toString());

        } catch (IOException e) {
            System.err.println("Error saving contract: " + e.getMessage());
        }
    }
}