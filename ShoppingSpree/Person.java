package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public void buyProduct (Product product) {
        if (this.money >= product.getCost()) {
            this.money -= product.getCost();
            this.products.add(product);
            System.out.println(this.getName() + " bought " + product.getName());
        } else {
            throw new IllegalArgumentException(this.getName() + " can't afford " + product.getName());
        }
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()) {
            return this.getName() + " - Nothing bought";
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append(this.getName()).append(" - ");

            for (int i = 0; i < this.products.size(); i++) {
                if (i < this.products.size() - 1) {
                    builder.append(this.products.get(i).getName()).append(", ");
                } else {
                    builder.append(this.products.get(i).getName());
                }
            }
            return builder.toString();
        }
    }
}
