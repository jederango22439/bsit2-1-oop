public class FoodOrderingSystem {
    public static void main(String[] args) {
        System.out.println("=== Food Ordering System ===\n");

        System.out.println("Creating orders and adding items...");

        Order order1 = new Order("Alice Johnson");
        Order order2 = new Order("Bob Smith");
        Order order3 = new Order("Charlie Brown");

        try {
            order1.addItem("Pizza", 12.99);
            System.out.println("Item 'Pizza' added successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order1.addMultipleItems(
                    new String[]{"Burger", "Fries"},
                    8.50, 3.25
            );
            System.out.println("Items added: Burger, Fries");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order1.addItem("Soda", 0); // Invalid price
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            order1.addItem("", 4.50); // Invalid item
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        order2.addMultipleItems(
                new String[]{"Sandwich", "Juice", "Cookie", "Chips", "Salad"},
                7.00, 4.00, 2.50, 3.45, 15.50
        );

        order3.addItem("Hotdog", 6.00);
        order3.addItem("Water", 9.50);

        System.out.println("\nOrder Results:");
        System.out.println(order1.displayOrder());
        System.out.println(order2.displayOrder());
        System.out.println(order3.displayOrder());

        System.out.println("\nTotal orders created: " + Order.getTotalOrders());

        Order largest = order1;
        if (order2.getTotalAmount() > largest.getTotalAmount()) largest = order2;
        if (order3.getTotalAmount() > largest.getTotalAmount()) largest = order3;

        System.out.printf("Largest order: %s ($%.2f)\n", largest.getCustomerName(), largest.getTotalAmount());
    }
}
