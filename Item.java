public class Item {
    private String name;
    private Category category;
    private int quantity;
    private double price;

    public Item(String name, Category category, int quantity, double price) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() { return name; }
    public Category getCategory() { return category; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getTotalPrice() { return quantity * price; }
}
