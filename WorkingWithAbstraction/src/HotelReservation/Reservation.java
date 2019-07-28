package HotelReservation;

public class Reservation {
    private double dailyPrice;
    private int days;
    private Season season;
    private Discount discount;

    public Reservation(double dailyPrice, int days, Season season, Discount discount) {
        this.dailyPrice = dailyPrice;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }

    public double getDailyPrice() {
        return this.dailyPrice;
    }

    public int getDays() {
        return this.days;
    }

    public Season getSeason() {
        return this.season;
    }

    public Discount getDiscount() {
        return this.discount;
    }
}
