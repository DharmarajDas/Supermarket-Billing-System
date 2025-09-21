import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int billCounter = 1000;

    public static void main(String[] args) {
        System.out.println("===== Welcome to the Supermarket Billing System =====");

        while (true) {
            System.out.println("\n1. New Customer Bill");
            System.out.println("2. Exit");
            System.out.print("Choose option: ");
            int choice = getIntInput();

            if (choice == 1) createBill();
            else if (choice == 2) break;
            else System.out.println("Invalid choice.");
        }
    }

    private static void createBill() {
        // CUSTOMER DETAILS
        System.out.print("Customer Name: ");
        String name = scanner.next();

        String phone;
        while (true) {
            System.out.print("Phone Number: ");
            phone = scanner.next();
            if (phone.matches("\\d{10}")) break;
            System.out.println("Invalid phone number. Must be 10 digits.");
        }

        String email;
        while (true) {
            System.out.print("Email: ");
            email = scanner.next();
            if (email.contains("@") && email.contains(".")) break;
            System.out.println("Invalid email. Try again.");
        }

        Customer customer = new Customer(name, phone, email);
        ArrayList<Item> items = new ArrayList<>();

        while (true) {
            System.out.print("Enter item name (or 'exit'): ");
            String itemName = scanner.next();
            if (itemName.equalsIgnoreCase("exit")) break;

            String categoryInput;
            Category category;
            while (true) {
                System.out.println("Enter category (Fruits/Vegetables/Dairy & Bakery/Beverages/Snacks/Meat & Seafood/Frozen Foods/Household Supplies/Personal Care/Electronics/Stationery/Other): ");
                categoryInput = scanner.nextLine();
                if (Category.isValid(categoryInput)) {
                    category = Category.fromString(categoryInput);
                    break;
                } else System.out.println("Invalid category!");
            }

            System.out.print("Enter quantity: ");
            int quantity = getIntInput();
            System.out.print("Enter price per unit: ");
            double price = getDoubleInput();

            Item existing = findItem(items, itemName);
            if (existing != null) existing.setQuantity(existing.getQuantity() + quantity);
            else items.add(new Item(itemName, category, quantity, price));
        }

        // Remove item option
        System.out.print("Do you want to remove any item? (yes/no): ");
        if (scanner.next().equalsIgnoreCase("yes")) {
            System.out.print("Enter item name to remove: ");
            String removeName = scanner.next();
            Item itemToRemove = findItem(items, removeName);
            if (itemToRemove != null) items.remove(itemToRemove);
        }

        System.out.print("Enter discount amount ($): ");
        double discount = getDoubleInput();

        // PAYMENT
        String paymentMethod = "";
        double amountPaid = 0;
        double balance = 0;
        System.out.println("Payment Method: 1.Cash 2.Card 3.UPI");
        int payChoice = getIntInput();
        Bill tempBill = new Bill(billCounter, customer, items, discount, "", 0, 0);
        double finalTotal = tempBill.getFinalTotal();

        switch (payChoice) {
            case 1:
                paymentMethod = "Cash";
                System.out.print("Enter cash amount: ");
                amountPaid = getDoubleInput();
                while (amountPaid < finalTotal) {
                    System.out.print("Insufficient! Enter again: ");
                    amountPaid = getDoubleInput();
                }
                balance = amountPaid - finalTotal;
                break;
            case 2: paymentMethod = "Card"; amountPaid = finalTotal; break;
            case 3: paymentMethod = "UPI"; amountPaid = finalTotal; break;
            default: paymentMethod = "Cash"; amountPaid = finalTotal; balance = 0;
        }

        Bill bill = new Bill(billCounter++, customer, items, discount, paymentMethod, amountPaid, balance);
        bill.printReceipt();
        bill.saveToFile();
    }

    private static Item findItem(ArrayList<Item> items, String name) {
        for (Item i : items) if (i.getName().equalsIgnoreCase(name)) return i;
        return null;
    }

    private static int getIntInput() {
        while (true) {
            try { return Integer.parseInt(scanner.next()); }
            catch (Exception e) { System.out.print("Invalid number! Enter again: "); }
        }
    }

    private static double getDoubleInput() {
        while (true) {
            try { return Double.parseDouble(scanner.next()); }
            catch (Exception e) { System.out.print("Invalid number! Enter again: "); }
        }
    }
}
