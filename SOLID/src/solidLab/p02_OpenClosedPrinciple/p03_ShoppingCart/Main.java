package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart("as@mail.net");
        cart.add(new OrderItem("EACH banana", 20));
        cart.add(new OrderItem("SPECIAL soup", 2));
        cart.add(new OrderItem("WEIGHT rice", 10));

        Order order = new OnlineOrder(cart);
        order.chekout();
    }
}
