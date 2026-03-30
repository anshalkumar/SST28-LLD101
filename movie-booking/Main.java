import java.util.*;

public class Main {
    public static void main(String[] args) {

        Seat s1 = new Seat(1, "REGULAR");
        Seat s2 = new Seat(2, "REGULAR");

        List<Seat> seats = Arrays.asList(s1, s2);

        Screen screen = new Screen(1, seats);
        Movie movie = new Movie(1, "Inception");

        Show show = new Show(1, movie, screen);

        User user = new User(1, "Sushant", "Bangalore");

        BookingService service = new BookingService();
        service.addShow(show);

        Booking b = service.bookTickets(user, show, Arrays.asList(s1));

        if (b != null) {
            service.cancelBooking(b);
        }
    }
}