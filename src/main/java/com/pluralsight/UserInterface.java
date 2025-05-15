package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private ContractDataManager contractDataManager;

    public UserInterface() {
        scanner = new Scanner(System.in);
        contractDataManager = new ContractDataManager();
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("1. Sell/Lease a Vehicle");
            System.out.println("2. Exit");
            System.out.print("Select an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    handleSaleOrLease();
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void handleSaleOrLease() {
        System.out.print("Enter Vehicle VIN: ");
        String vin = scanner.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Customer Email: ");
        String customerEmail = scanner.nextLine();

        System.out.print("Enter Date (YYYYMMDD): ");
        String date = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Is this a Sale or Lease? (S/L): ");
        String contractType = scanner.nextLine();

        if (contractType.equalsIgnoreCase("S")) {
            System.out.print("Is this financed? (yes/no): ");
            boolean isFinanced = scanner.nextLine().equalsIgnoreCase("yes");
            SalesContract salesContract = new SalesContract(date, customerName, customerEmail, vin, price, isFinanced);
            contractDataManager.saveContract(salesContract);
            System.out.println("Sales contract saved.");
        } else if (contractType.equalsIgnoreCase("L")) {
            if (isOlderThanThreeYears(vin)) {
                System.out.println("Leasing not available for vehicles older than 3 years.");
            } else {
                LeaseContract leaseContract = new LeaseContract(date, customerName, customerEmail, vin, price);
                contractDataManager.saveContract(leaseContract);
                System.out.println("Lease contract saved.");
            }
        } else {
            System.out.println("Invalid option.");
        }
    }

    private boolean isOlderThanThreeYears(String vin) {
        // Placeholder: Implement logic to check vehicle year based on VIN
        return false;
    }

    public void display() {
    }
}
