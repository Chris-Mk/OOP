package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public abstract class Order {
    private final Cart cart;

    protected Order(Cart cart) {
        this.cart = cart;
    }

    void chekout(){
        System.out.println(this.cart.getTotalAmount());
        this.cart.getItems()
                .forEach(orderItem -> System.out.println(String.format("%s -> %d",
                orderItem.getName(),
                orderItem.getQuantity())));
    }
}
