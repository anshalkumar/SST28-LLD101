import java.util.*;

public class Booking {
    int id;
    User user;
    Show show;
    List<Seat> seats;
    String status;

    public Booking(int id, User user, Show show, List<Seat> seats) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.status = "CONFIRMED";
    }
}