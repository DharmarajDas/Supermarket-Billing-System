# Supermarket-Billing-System-Java

A fully-featured **Supermarket Billing System** built in Java. Supports multiple customers, item categories with automatic tax calculation, discounts, payment methods (Cash/Card/UPI), customer details tracking, and generates formatted receipts saved as `.txt` files.

---

## Features

- Customer management (name, phone, email)
- Multiple item categories (Fruits, Vegetables, Dairy & Bakery, Electronics, Snacks, Beverages, etc.)
- Automatic tax calculation based on category
- Discount handling
- Payment methods with balance calculation for cash payments
- Search, update, and remove items
- Generate and save receipts as `.txt` files
- Input validation for all fields
- Auto-generate bill ID and date/time on receipts

---

## Prerequisites

- Java JDK 8 or higher installed
- Any Java IDE (Eclipse, IntelliJ, VS Code) or command-line environment
- Basic knowledge of running Java programs

---

## How to Run

### Using an IDE:
1. Clone or download the repository.
2. Open the project in your IDE.
3. Make sure all Java files (`Main.java`, `Item.java`, `Customer.java`, `Bill.java`, `Category.java`) are in the correct package/folder.
4. Compile and run `Main.java`.
5. Follow the console instructions to:
   - Enter customer details (name, phone, email)
   - Add items with quantity, price, and category
   - Apply discount (optional)
   - Choose payment method (Cash, Card, UPI)
6. The bill will be displayed on the console and saved as a `.txt` file in the project folder.

### Using Command-Line:
1. Open terminal/command prompt.
2. Navigate to the project directory.
3. Compile all Java files:
   ```bash
   javac *.java
4. Run the main class:
   java Main
5. Follow on-screen prompts as described above.
   Sample Output:
   ===== SUPERMARKET BILL =====
Bill ID: 1001
Date: 21-09-2025 12:35:10
Customer: John Doe
Phone: 9876543210
Email: john@example.com
----------------------------------------------
Name            Qty        Price       Total
----------------------------------------------
Apple           3          50.00       150.00
Bread           2          40.00       80.00
Milk            1          60.00       60.00
----------------------------------------------
Subtotal: 290.00
Tax: 14.50
Discount: 10.00
Final Total: 294.50
Payment Method: Cash
Amount Paid: 300.00
Balance Returned: 5.50
==============================================

---

## Technologies Used

Java

Object-Oriented Programming (OOP)

File handling for receipt storage

---

## Future Improvements

Add GUI interface (Swing or JavaFX)

Store bills in a database (MySQL/PostgreSQL)

Generate PDF receipts

Email receipts to customers

Advanced reporting and analytics

Mobile app integration

---

## Author

Dharmaraj

A Java enthusiast building practical console-based applications.

