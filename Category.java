public enum Category {
    FRUITS(5),
    VEGETABLES(2),
    DAIRY_BAKERY(5),
    BEVERAGES(12),
    SNACKS(10),
    MEAT_SEAFOOD(8),
    FROZEN_FOODS(8),
    HOUSEHOLD_SUPPLIES(15),
    PERSONAL_CARE(12),
    ELECTRONICS(18),
    STATIONERY(10),
    OTHER(10);

    private final double taxRate;

    Category(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public static boolean isValid(String input) {
        for (Category c : Category.values()) {
            if (c.name().replace("_"," ").equalsIgnoreCase(input)) return true;
        }
        return false;
    }

    public static Category fromString(String input) {
        for (Category c : Category.values()) {
            if (c.name().replace("_"," ").equalsIgnoreCase(input)) return c;
        }
        return OTHER;
    }
}

