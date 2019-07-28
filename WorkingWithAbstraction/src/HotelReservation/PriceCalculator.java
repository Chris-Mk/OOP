package HotelReservation;

public class PriceCalculator {
    private Reservation reservation;

    public PriceCalculator(Reservation reservation) {
        this.reservation = reservation;
    }

    public double getToTalPrice() {
        double price =  this.reservation.getDailyPrice() * this.reservation.getSeason().getPrice() * this.reservation.getDays();
        price *= 1 -  this.reservation.getDiscount().getDiscount() / 100.0;
        return price;
    }
}
