package HotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int price;

    Season(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
