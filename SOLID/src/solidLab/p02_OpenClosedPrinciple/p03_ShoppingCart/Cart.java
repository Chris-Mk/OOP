package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<OrderItem> items;
    private String customerEmail;

    public Cart(String customerEmail) {
        this.customerEmail = customerEmail;
        this.items = new ArrayList<>();
    }

    public Iterable<OrderItem> getItems() {
        return this.items;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void add(OrderItem orderItem) {
        this.items.add(orderItem);
    }

    public double getTotalAmount() {
        double total = 0;

        for (var item : this.items) {
            if (item.getName().startsWith("EACH")) {
                total += item.getQuantity() * 5.0;
            } else if (item.getName().startsWith("WEIGHT")) {
                // quantity is in grams, price is per kg
                total += item.getQuantity() * 4.0 / 1000;
            } else if (item.getName().startsWith("SPECIAL")) {
                // $0.40 each; 3 for $1.00
                total += item.getQuantity() * 4.0;
                int setsOfThree = item.getQuantity() / 3;
                total -= setsOfThree * 2.0;
            }

            // more rules are coming!
        }

        return total;
    }
}
