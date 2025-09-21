import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Bill {
    private int billID;
    private Customer customer;
    private ArrayList<Item> items;
    private double discount;
    private String paymentMethod;
    private double amountPaid;
    private double balance;

    public Bill(int billID, Customer customer, ArrayList<Item> items,
                double discount, String paymentMethod, double amountPaid, double balance) {
        this.billID = billID;
        this.customer = customer;
        this.items = items;
        this.discount = discount;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
        this.balance = balance;
    }

    public double getSubTotal() {
        double subtotal = 0;
        for (Item item : items) subtotal += item.getTotalPrice();
        return subtotal;
    }

    public double getTaxTotal() {
        double taxTotal = 0;
        for (Item item : items)
            taxTotal += item.getTotalPrice() * item.getCategory().getTaxRate() / 100;
        return taxTotal;
    }

    public double getFinalTotal() {
        return getSubTotal() + getTaxTotal() - discount;
    }

    public void printReceipt() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("\n===== SUPERMARKET BILL =====");
        System.out.println("Bill ID: " + billID);
        System.out.println("Date: " + now.format(formatter));
        System.out.println("Customer: " + customer.getName());
        System.out.println("Phone: " + customer.getPhone());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("----------------------------------------------");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Name", "Qty", "Price", "Total");
        System.out.println("----------------------------------------------");

        for (Item item : items) {
            System.out.printf("%-15s %-10d %-10.2f %-10.2f\n",
                    item.getName(), item.getQuantity(), item.getPrice(), item.getTotalPrice());
        }

        System.out.println("----------------------------------------------");
        System.out.printf("Subtotal: %.2f\n", getSubTotal());
        System.out.printf("Tax: %.2f\n", getTaxTotal());
        System.out.printf("Discount: %.2f\n", discount);
        System.out.printf("Final Total: %.2f\n", getFinalTotal());
        System.out.println("Payment Method: " + paymentMethod);
        System.out.printf("Amount Paid: %.2f\n", amountPaid);
        if (paymentMethod.equals("Cash")) System.out.printf("Balance Returned: %.2f\n", balance);
        System.out.println("==============================================");
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("Bill_" + billID + ".txt");
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            writer.write("===== SUPERMARKET BILL =====\n");
            writer.write("Bill ID: " + billID + "\n");
            writer.write("Date: " + now.format(formatter) + "\n");
            writer.write("Customer: " + customer.getName() + "\n");
            writer.write("Phone: " + customer.getPhone() + "\n");
            writer.write("Email: " + customer.getEmail() + "\n");
            writer.write("----------------------------------------------\n");
            writer.write(String.format("%-15s %-10s %-10s %-10s\n", "Name", "Qty", "Price", "Total"));
            writer.write("----------------------------------------------\n");

            for (Item item : items) {
                writer.write(String.format("%-15s %-10d %-10.2f %-10.2f\n",
                        item.getName(), item.getQuantity(), item.getPrice(), item.getTotalPrice()));
            }

            writer.write("----------------------------------------------\n");
            writer.write(String.format("Subtotal: %.2f\n", getSubTotal()));
            writer.write(String.format("Tax: %.2f\n", getTaxTotal()));
            writer.write(String.format("Discount: %.2f\n", discount));
            writer.write(String.format("Final Total: %.2f\n", getFinalTotal()));
            writer.write("Payment Method: " + paymentMethod + "\n");
            writer.write(String.format("Amount Paid: %.2f\n", amountPaid));
            if (paymentMethod.equals("Cash")) writer.write(String.format("Balance Returned: %.2f\n", balance));
            writer.write("==============================================\n");
            writer.close();
            System.out.println("Bill saved to file: Bill_" + billID + ".txt");
        } catch (IOException e) {
            System.out.println("Error saving bill!");
        }
    }
}
